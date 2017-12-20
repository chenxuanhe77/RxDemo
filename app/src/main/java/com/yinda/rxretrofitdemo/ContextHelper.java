package com.yinda.rxretrofitdemo;

import android.content.Context;


public class ContextHelper {

    private static Context mContext;

    public static Context getActivityContext() {
        return mContext;
    }

    public static void setActivityContext(Context context) {
        mContext = context;
    }
}
