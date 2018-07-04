/*
 * Created by Ahmed Karim on 30/06/18 15:56
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 15:56
 */

package com.onadasoft.tasksetgo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "list_table")
public class List {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "color")
    private int mColor;

    public List(int mId, @NonNull String mName, int mColor) {
        this.mId = mId;
        this.mName = mName;
        this.mColor = mColor;
    }

    @NonNull
    public int getId() {
        return mId;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public int getColor() {
        return mColor;
    }
}
