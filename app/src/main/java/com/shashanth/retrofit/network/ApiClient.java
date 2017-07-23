package com.shashanth.retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shashanth
 */

public class ApiClient {

    private static Retrofit retrofit = null;
    private static APIService apiService = null;

    public static APIService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(APIService.class);
        }
        return apiService;
    }
}
