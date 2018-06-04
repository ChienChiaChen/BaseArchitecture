package com.chiachen.myarchitecture.data.network;

import com.chiachen.myarchitecture.data.network.exception.NoNetworkException;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.HttpException;


public abstract class SingleApiCallback<M> extends DisposableSingleObserver<M> {
    public static final String NETWORK_ERROR = "Network error";
    public static final String SERVER_ERROR = "Server error";

    public abstract void onSuccess(M model);
    public abstract void onFailure(String msg);

    @Override
    public void onError(Throwable throwable) {
        if (throwable instanceof NoNetworkException) {
            onFailure("No Network");
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            int errCode = httpException.code();
            String errMsg = httpException.message();

            if (HttpsURLConnection.HTTP_GATEWAY_TIMEOUT == errCode) {
                errMsg = SingleApiCallback.NETWORK_ERROR;
            } else if (HttpsURLConnection.HTTP_BAD_GATEWAY == errCode || HttpsURLConnection.HTTP_NOT_FOUND == errCode) {
                errMsg = SingleApiCallback.SERVER_ERROR;
            }

            onFailure(errMsg);
        } else {
            onFailure(throwable.getMessage());
        }
    }
}
