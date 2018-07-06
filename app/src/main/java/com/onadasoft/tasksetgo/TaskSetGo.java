/*
 * Created by Ahmed Karim on 30/06/18 18:41
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 18:41
 */

package com.onadasoft.tasksetgo;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.onadasoft.tasksetgo.concurrence.AppExecutors;
import com.onadasoft.tasksetgo.db.AppDatabase;

public class TaskSetGo extends Application {

    private AppExecutors mAppExecutors;
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidThreeTen.init(this);

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository(){
        return DataRepository.getInstance(getDatabase());
    }
}
