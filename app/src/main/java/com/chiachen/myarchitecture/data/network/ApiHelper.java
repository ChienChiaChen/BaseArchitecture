package com.chiachen.myarchitecture.data.network;

import com.chiachen.myarchitecture.data.network.model.BlogResponse;
import com.chiachen.myarchitecture.data.network.model.OpenSourceResponse;

import io.reactivex.Single;


public interface ApiHelper {
    Single<OpenSourceResponse> getOpenSourceApiCall();
    Single<BlogResponse> getBlogApiCall();
}
