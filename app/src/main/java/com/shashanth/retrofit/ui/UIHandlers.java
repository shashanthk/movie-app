package com.shashanth.retrofit.ui;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by shashanth
 */

public class UIHandlers {

    public static void showShortToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
