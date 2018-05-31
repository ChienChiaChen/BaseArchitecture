package com.chiachen.myarchitecture.ui.main;

import com.chiachen.myarchitecture.base.BasePresenter;
import com.chiachen.myarchitecture.di.PerActivity;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends BasePresenter<V> {

    void onDrawerOptionAboutClick();
}
