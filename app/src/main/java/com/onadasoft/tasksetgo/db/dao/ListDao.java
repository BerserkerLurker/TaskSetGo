/*
 * Created by Ahmed Karim on 30/06/18 23:02
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 23:02
 */

package com.onadasoft.tasksetgo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.onadasoft.tasksetgo.db.entity.ListEntity;

import java.util.List;

@Dao
public interface ListDao {

    @Insert
    void insertList(ListEntity list);

    @Insert
    void insertAllLists(List<ListEntity> lists);

    @Insert
    long insertListGetId(ListEntity list);

    @Update
    void updateLists(ListEntity... lists);

    @Delete
    void deleteLists(ListEntity... lists);

    // TODO -- which Query should return a LiveData Object??

    @Query("SELECT * FROM list_table ORDER BY color ASC")
    LiveData<List<ListEntity>> loadAllListsByColor();

    @Query("SELECT * FROM list_table")
    LiveData<List<ListEntity>> loadAllLists();


    @Query("SELECT * FROM list_table ORDER BY name ASC")
    LiveData<List<ListEntity>> loadAllListsByName();

}
