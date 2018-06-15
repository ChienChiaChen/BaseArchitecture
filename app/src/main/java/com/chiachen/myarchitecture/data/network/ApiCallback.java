package com.chiachen.myarchitecture.data.network;

import java.net.HttpURLConnection;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

public abstract class ApiCallback<M> extends DisposableObserver<M> {

    public abstract void onSuccess(M model);
    public abstract void onFailure(String msg);
    public abstract void onFinish();

    @Override
    public void onNext(M m) {
        onSuccess(m);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;

            int errCode = httpException.code();
            String errMsg = httpException.message();

            if (HttpURLConnection.HTTP_GATEWAY_TIMEOUT == errCode) {
                errMsg = "timeout error";
            } else if (HttpURLConnection.HTTP_BAD_GATEWAY == errCode || HttpURLConnection.HTTP_NOT_FOUND == errCode) {
                errMsg = "Server error";
            }

            onFailure(errMsg);
        } else {
            onFailure(e.getMessage());
        }

        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
