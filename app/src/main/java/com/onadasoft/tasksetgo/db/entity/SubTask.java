/*
 * Created by Ahmed Karim on 30/06/18 21:32
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 21:32
 */

package com.onadasoft.tasksetgo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "subtask",
        foreignKeys = @ForeignKey(entity = Task.class,
                                  parentColumns = "id",
                                  childColumns = "task_id"))
public class SubTask {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "task_id")
    private int mTaskId;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    public SubTask(int mId, int mTaskId, @NonNull String mTitle) {
        this.mId = mId;
        this.mTaskId = mTaskId;
        this.mTitle = mTitle;
    }

    @NonNull
    public int getId() {
        return mId;
    }

    @NonNull
    public int getTaskId() {
        return mTaskId;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }
}
