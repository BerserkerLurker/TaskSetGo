/*
 * Created by Ahmed Karim on 06/07/18 20:31
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 06/07/18 20:31
 */

package com.onadasoft.tasksetgo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.onadasoft.tasksetgo.TaskSetGo;
import com.onadasoft.tasksetgo.db.entity.TaskEntity;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<TaskEntity>> mObservableTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);

        mObservableTasks = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableTasks.setValue(null);

        LiveData<List<TaskEntity>> lists = ((TaskSetGo)application).getRepository().getTasks();

        // observe the changes of the tasks from the database and forward them
        mObservableTasks.addSource(lists, mObservableTasks::setValue);

    }
    /**
     * Expose the LiveData Tasks query so the UI can observe it.
     */
    public LiveData<List<TaskEntity>> getTasks() {
        return mObservableTasks;
    }
}