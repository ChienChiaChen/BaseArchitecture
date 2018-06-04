package com.chiachen.myarchitecture.ui.blog;

import com.chiachen.myarchitecture.base.BasePresenterImpl;
import com.chiachen.myarchitecture.data.DataManager;
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
    }
}
