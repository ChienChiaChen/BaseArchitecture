package com.chiachen.myarchitecture.ui.blog;

import com.chiachen.myarchitecture.base.BasePresenterImpl;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.network.SingleApiCallback;
import com.chiachen.myarchitecture.data.network.model.BlogResponse;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogMvpView;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BlogPresenter <V extends BlogMvpView> extends BasePresenterImpl<V> implements BlogMvpPresenter<V> {

    @Inject
    public BlogPresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable,
                         DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(
                getDataManager()
                    .getBlogApiCall()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribeWith(
                            new SingleApiCallback<BlogResponse>(){
                                   @Override
                                   public void onSuccess(BlogResponse blogResponse) {
                                       getMvpView().hideLoading();
                                       if (blogResponse != null && blogResponse.getData() != null) {
                                           getMvpView().updateBlog(blogResponse.getData());
                                       }
                                   }

                                   @Override
                                   public void onFailure(String msg) {
                                       if (!isViewAttached()) return;

                                       getMvpView().hideLoading();
                                       getMvpView().showSnackBar(msg);
                                   }
                    })
        );

    }
}
