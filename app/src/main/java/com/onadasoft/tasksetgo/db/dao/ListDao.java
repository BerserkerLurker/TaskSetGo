/*
 * Created by Ahmed Karim on 30/06/18 23:02
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 23:02
 */

package com.onadasoft.tasksetgo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.onadasoft.tasksetgo.db.entity.List;

@Dao
public interface ListDao {

    @Insert
    void insertList(List list);

    @Insert
    long insertListGetId(List list);

    @Update
    void updateLists(List... lists);

    @Delete
    void deleteLists(List... lists);

    @Query("SELECT * FROM list_table ORDER BY color ASC")
    java.util.List<List> loadAllLists();

}
