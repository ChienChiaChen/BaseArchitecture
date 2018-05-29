package com.chiachen.myarchitecture.ui.splash;

import android.util.Log;

import com.chiachen.myarchitecture.base.BasePresenterImpl;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.network.ApiCallback;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenterImpl<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    public void loadData() {
        getMvpView().showLoading();
        addSubscription(
                Observable.empty().delay(3, TimeUnit.SECONDS),
                new ApiCallback<Integer>() {
                    @Override
                    public void onSuccess(Integer integer) {
                        getMvpView().onError(String.valueOf(integer));
                        Log.d("JASON_CHIEN", "\nonSuccess" + integer);
                    }

                    @Override
                    public void onFailure(String msg) {
                        getMvpView().onError(msg);
                        Log.d("JASON_CHIEN", "\nonFailure");
                    }

                    @Override
                    public void onFinish() {
                        getMvpView().hideLoading();
                        Log.d("JASON_CHIEN", "\nonFinish");
                    }
                }
        );
    }
}
