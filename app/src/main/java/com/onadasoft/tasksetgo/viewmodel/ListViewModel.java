/*
 * Created by Ahmed Karim on 06/07/18 20:14
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 06/07/18 20:14
 */

package com.onadasoft.tasksetgo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.onadasoft.tasksetgo.TaskSetGo;
import com.onadasoft.tasksetgo.db.entity.ListEntity;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<ListEntity>> mObservableLists;

    public ListViewModel(@NonNull Application application) {
        super(application);

        mObservableLists = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableLists.setValue(null);

        LiveData<List<ListEntity>> lists = ((TaskSetGo)application).getRepository().getLists();

        // observe the changes of the lists from the database and forward them
        mObservableLists.addSource(lists, mObservableLists::setValue);

    }

    /**
     * Expose the LiveData Lists query so the UI can observe it.
     */
    public LiveData<List<ListEntity>> getLists() {
        return mObservableLists;
    }
}
