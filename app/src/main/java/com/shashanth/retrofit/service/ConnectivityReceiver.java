package com.shashanth.retrofit.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.shashanth.retrofit.network.NetworkUtil;

/**
 * Created by shashanth on 9/7/17.
 */

public class ConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityListener;

    public ConnectivityReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityListener != null) {
            connectivityListener.onConnectivityChanged(NetworkUtil.isNetworkAvailable(context));
        }
    }
}
