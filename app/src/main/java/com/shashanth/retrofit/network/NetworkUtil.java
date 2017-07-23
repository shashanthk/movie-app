package com.shashanth.retrofit.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by shashanth
 */

public final class NetworkUtil {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isNotNetworkAvailable(Context context) {
        return !isNetworkAvailable(context);
    }

    public static void loadImage(Context context, String url, ImageView view) {
        url = Constants.IMG_BASE_URL + url;
        Glide.with(context)
                .load(url)
//                .placeholder(R.drawable.loading_spinner)
                .into(view);

    }
}