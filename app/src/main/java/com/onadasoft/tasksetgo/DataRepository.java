/*
 * Created by Ahmed Karim on 05/07/18 21:29
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 05/07/18 21:29
 */

package com.onadasoft.tasksetgo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.onadasoft.tasksetgo.db.AppDatabase;
import com.onadasoft.tasksetgo.db.entity.ListEntity;
import com.onadasoft.tasksetgo.db.entity.SubTaskEntity;
import com.onadasoft.tasksetgo.db.entity.TaskEntity;

import java.util.List;

public class DataRepository {

    private static  DataRepository sInstance;

    private final AppDatabase mDatabase;

    private MediatorLiveData<List<TaskEntity>> mObservableTasks;
    private MediatorLiveData<List<ListEntity>> mObservableLists;

    private DataRepository(final AppDatabase database){
        mDatabase = database;
        mObservableTasks = new MediatorLiveData<>();
        mObservableLists = new MediatorLiveData<>();

        mObservableTasks.addSource(mDatabase.taskDao().loadAllTasks(),
                taskEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableTasks.postValue(taskEntities);
                    }
                });

        mObservableLists.addSource(mDatabase.listDao().loadAllLists(),
                listEntities -> {
                    if(mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableLists.postValue(listEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database){
        if (sInstance == null){
            synchronized (DataRepository.class){
                if (sInstance == null){
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of tasks from the database and get notified when the data changes.
     */
    public LiveData<List<TaskEntity>> getTasks() {
        return mObservableTasks;
    }

    /**
     * Get the list of lists from the database and get notified when the data changes.
     */
    public LiveData<List<ListEntity>> getLists() {
        return mObservableLists;
    }

    // TODO -- Load single task, list, subTask: not needed??

    public LiveData<List<SubTaskEntity>> loadSubTasks(final int taskId){
        return  mDatabase.subTaskDao().loadSubTasksWithTaskId(taskId);
    }
}
