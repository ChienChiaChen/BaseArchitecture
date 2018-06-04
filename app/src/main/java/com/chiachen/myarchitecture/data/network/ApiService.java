package com.chiachen.myarchitecture.data.network;

import com.chiachen.myarchitecture.data.network.config.ApiEndPoint;
import com.chiachen.myarchitecture.data.network.model.BlogResponse;
import com.chiachen.myarchitecture.data.network.model.OpenSourceResponse;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
    Single<OpenSourceResponse> getOpenSourceApiCall();

    @GET(ApiEndPoint.ENDPOINT_BLOG)
    Single<BlogResponse> getBlogApiCall();
}
