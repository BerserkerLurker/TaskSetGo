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


@Entity(tableName = "subtask_table",
        foreignKeys = @ForeignKey(entity = TaskEntity.class,
                                  parentColumns = "id",
                                  childColumns = "task_id"))
public class SubTaskEntity {

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

    public SubTaskEntity(){}

    public SubTaskEntity(int mId, int mTaskId, @NonNull String mTitle) {
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

    public void setId(@NonNull int mId) {
        this.mId = mId;
    }

    public void setTaskId(@NonNull int mTaskId) {
        this.mTaskId = mTaskId;
    }

    public void setTitle(@NonNull String mTitle) {
        this.mTitle = mTitle;
    }
}
