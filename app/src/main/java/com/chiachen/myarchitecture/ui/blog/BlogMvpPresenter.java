package com.chiachen.myarchitecture.ui.blog;

import com.chiachen.myarchitecture.base.BasePresenter;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogMvpView;

public interface BlogMvpPresenter<V extends BlogMvpView> extends BasePresenter<V> {
    void onViewPrepared();
}


