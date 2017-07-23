package com.shashanth.retrofit.util;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by shashanth on 23/7/17.
 */

public class Util {

    private static final SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat displayDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

    public static String dbToDisplay(String dbDate) {

        if (TextUtils.isEmpty(dbDate)) {
            return "invalid date";
        }

        Date date;

        try {
            date = dbDateFormat.parse(dbDate);
        } catch (ParseException ex) {
            Log.e("UTIL", "dbToDisplay: ParseException ", ex);
            return "invalid date";
        }
        return date == null ? "" : displayDateFormat.format(date);
    }
}
