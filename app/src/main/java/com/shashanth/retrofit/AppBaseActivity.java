package com.shashanth.retrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shashanth.retrofit.ui.UIHandlers;

public class AppBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected static void showShortToast(Context context, String msg) {
        UIHandlers.showShortToast(context, msg);
    }

    protected static void showLongToast(Context context, String msg) {
        UIHandlers.showLongToast(context, msg);
    }

    protected static void loge(String tag, Throwable t) {
        Log.e(tag, "Error: ", t);
    }

    protected static void logi(String tag, String msg) {
        Log.i(tag, "Log: " + msg);
    }
}
