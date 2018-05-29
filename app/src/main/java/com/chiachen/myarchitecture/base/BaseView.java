package com.chiachen.myarchitecture.base;

import android.support.annotation.StringRes;

public interface BaseView {

    void showLoading();
    void hideLoading();

    void onError(@StringRes int resId);
    void onError(String msg);

    void showMsg(@StringRes int resId);
    void showMsg(String msg);

    boolean isNetworkedConnected();
}
