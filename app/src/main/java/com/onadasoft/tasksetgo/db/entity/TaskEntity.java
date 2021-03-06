/*
 * Created by Ahmed Karim on 30/06/18 16:29
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 16:29
 */

package com.onadasoft.tasksetgo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.threeten.bp.OffsetDateTime;

@Entity(tableName = "task_table",
        foreignKeys = @ForeignKey(entity = ListEntity.class,
                                  parentColumns = "id",
                                  childColumns = "list_id"))
public class TaskEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "list_id")
    private int mListId;

    @ColumnInfo(name = "number_subtasks")
    private int mNumberSubtasks = 0;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "description")
    private String mDescription;

    @ColumnInfo(name = "location")
    private String mLocation;

    @ColumnInfo(name = "status")
    private int mStatus = 0;

    @ColumnInfo(name = "progress")
    private int mProgress = 0;

    @ColumnInfo(name = "priority")
    private int mPriority = 0;

    @ColumnInfo(name = "start_at")
    private OffsetDateTime mStartAt;

    @ColumnInfo(name = "deadline")
    private OffsetDateTime mDeadline;

    @ColumnInfo(name = "deadline_warning")
    private OffsetDateTime mDeadlineWarning;

    @ColumnInfo(name = "confidentiality")
    private int mConfidentiality = 0;

    @ColumnInfo(name = "url")
    private String mUrl;

    @ColumnInfo(name = "trash")
    private int mTrash = 0;


    public TaskEntity(){}

    public TaskEntity(int mId, int mListId, int mNumberSubtasks, @NonNull String mTitle,
                      String mDescription, String mLocation, int mStatus, int mProgress, int mPriority,
                      OffsetDateTime mStartAt, OffsetDateTime mDeadline, OffsetDateTime mDeadlineWarning,
                      int mConfidentiality, String mUrl, int mTrash) {
        this.mId = mId;
        this.mListId = mListId;
        this.mNumberSubtasks = mNumberSubtasks;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mLocation = mLocation;
        this.mStatus = mStatus;
        this.mProgress = mProgress;
        this.mPriority = mPriority;
        this.mStartAt = mStartAt;
        this.mDeadline = mDeadline;
        this.mDeadlineWarning = mDeadlineWarning;
        this.mConfidentiality = mConfidentiality;
        this.mUrl = mUrl;
        this.mTrash = mTrash;
    }

    @NonNull
    public int getId() {
        return mId;
    }

    @NonNull
    public int getListId() {
        return mListId;
    }

    public int getNumberSubtasks() {
        return mNumberSubtasks;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getStatus() {
        return mStatus;
    }

    public int getProgress() {
        return mProgress;
    }

    public int getPriority() {
        return mPriority;
    }

    public OffsetDateTime getStartAt() {
        return mStartAt;
    }

    public OffsetDateTime getDeadline() {
        return mDeadline;
    }

    public OffsetDateTime getDeadlineWarning() {
        return mDeadlineWarning;
    }

    public int getConfidentiality() {
        return mConfidentiality;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getTrash() {
        return mTrash;
    }

    public void setId(@NonNull int mId) {
        this.mId = mId;
    }

    public void setListId(@NonNull int mListId) {
        this.mListId = mListId;
    }

    public void setNumberSubtasks(int mNumberSubtasks) {
        this.mNumberSubtasks = mNumberSubtasks;
    }

    public void setTitle(@NonNull String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public void setProgress(int mProgress) {
        this.mProgress = mProgress;
    }

    public void setPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    public void setStartAt(OffsetDateTime mStartAt) {
        this.mStartAt = mStartAt;
    }

    public void setDeadline(OffsetDateTime mDeadline) {
        this.mDeadline = mDeadline;
    }

    public void setDeadlineWarning(OffsetDateTime mDeadlineWarning) {
        this.mDeadlineWarning = mDeadlineWarning;
    }

    public void setConfidentiality(int mConfidentiality) {
        this.mConfidentiality = mConfidentiality;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setTrash(int mTrash) {
        this.mTrash = mTrash;
    }
}
