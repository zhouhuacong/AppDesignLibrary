package com.zhc.appdesignlibrary.absFactory;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by qqq on 2017/2/23.
 */

public class ConcreateProductA extends Product {

    @Override
    public void method() {
        Log.i(TAG, "I'm product A");
    }
}
