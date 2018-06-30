/*
 * Created by Ahmed Karim on 30/06/18 18:41
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 18:41
 */

package com.onadasoft.tasksetgo;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class TaskSetGo extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidThreeTen.init(this);
    }
}
