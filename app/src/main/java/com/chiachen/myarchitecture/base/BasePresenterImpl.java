package com.chiachen.myarchitecture.base;

import android.util.Log;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.error.ANError;
import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.network.model.ApiError;
import com.chiachen.myarchitecture.utils.AppConstants;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.lang.ref.WeakReference;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class BasePresenterImpl <V extends BaseView> implements BasePresenter<V>{

    public static final String TAG = "BasePresenterImpl";

    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final DataManager mDataManager;

    private WeakReference<V> mView;

    @Inject
    public BasePresenterImpl(
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable,
            DataManager dataManager) {

        mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = compositeDisposable;
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mView = new WeakReference<>(mvpView);
    }

    @Override
    public void onDetach() {
        if (isViewAttached()) {
            this.mView.clear();
            this.mView = null;
        }
        mCompositeDisposable.dispose();
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public V getMvpView() {
        return mView.get();
    }

    @Override
    public void handleApiError(ANError error) {
        if (error == null || error.getErrorBody() == null) {
            getMvpView().onError(R.string.error_api_default);
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR && error.getErrorDetail().equals(ANConstants.CONNECTION_ERROR)) {
            getMvpView().onError(R.string.error_connection);
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR && error.getErrorDetail().equals(ANConstants.REQUEST_CANCELLED_ERROR)) {
            getMvpView().onError(R.string.error_api_retry);
            return;
        }

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        try {
            ApiError apiError = gson.fromJson(error.getErrorBody(), ApiError.class);

            if (apiError == null || apiError.getMessage() == null) {
                getMvpView().onError(R.string.error_api_default);
                return;
            }

            switch (error.getErrorCode()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                case HttpsURLConnection.HTTP_FORBIDDEN:
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                case HttpsURLConnection.HTTP_NOT_FOUND:
                default:
                    getMvpView().onError(apiError.getMessage());
            }
        } catch (JsonSyntaxException | NullPointerException e) {
            Log.e(TAG, "handleApiError", e);
            getMvpView().onError(R.string.error_api_default);
        }
    }

    public void addSubscription(Observable observable, DisposableObserver observer) {
        mCompositeDisposable.add(observer);
        observable.subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribeWith(observer);
    }

    public boolean isViewAttached() {
        return null != mView && null != mView.get();
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MVPViewNotAttachedException();
    }

    public static class MVPViewNotAttachedException extends RuntimeException {
        public MVPViewNotAttachedException() {
            super("Plz invoke Presenter.onAttach(view) before requesting data to the presenter");
        }

    }
}
