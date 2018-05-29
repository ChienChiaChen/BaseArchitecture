package com.chiachen.myarchitecture.ui.splash;

import com.chiachen.myarchitecture.base.BasePresenter;
import com.chiachen.myarchitecture.di.PerActivity;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends BasePresenter<V> {

    void loadData();
}
