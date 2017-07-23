package com.shashanth.retrofit.service;

import android.app.Application;

/**
 * Created by shashanth
 */

public class AppContext extends Application {

    private static AppContext appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public static synchronized AppContext getInstance() {
        return appInstance;
    }

    public void setConnectivityListener(ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityListener = listener;
    }
}
