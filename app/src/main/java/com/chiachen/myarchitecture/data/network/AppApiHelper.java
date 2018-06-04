package com.chiachen.myarchitecture.data.network;

import com.chiachen.myarchitecture.data.network.model.OpenSourceResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppApiHelper implements ApiHelper {

    private ApiService mApiService;

    @Inject
    public AppApiHelper(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiService.getOpenSourceApiCall();
    }
}
