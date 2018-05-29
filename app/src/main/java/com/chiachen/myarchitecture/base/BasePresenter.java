package com.chiachen.myarchitecture.base;

import com.androidnetworking.error.ANError;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

}
