package com.chiachen.myarchitecture.ui.main;

import com.chiachen.myarchitecture.base.BasePresenter;


public interface MainMvpPresenter<V extends MainMvpView> extends BasePresenter<V> {

    void onDrawerOptionAboutClick();
}
