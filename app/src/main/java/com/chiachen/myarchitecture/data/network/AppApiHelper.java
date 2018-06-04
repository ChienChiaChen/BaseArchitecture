package com.chiachen.myarchitecture.data.network;

import com.chiachen.myarchitecture.data.network.model.OpenSourceResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppApiHelper implements ApiHelper {

    @Inject
    ApiService mApiService;

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiService.getOpenSourceApiCall();
    }
}
