package com.shashanth.retrofit.network;

import retrofit2.Response;

/**
 * Created by shashanth
 */

public interface HttpResponseListener<T> {
    void onResponse(Response<T> response);
    void onFailure(Throwable t);
}
