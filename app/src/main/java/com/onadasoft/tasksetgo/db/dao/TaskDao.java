/*
 * Created by Ahmed Karim on 01/07/18 14:21
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/07/18 14:21
 */

package com.onadasoft.tasksetgo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.onadasoft.tasksetgo.db.entity.TaskEntity;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(TaskEntity task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTasks(List<TaskEntity> tasks);

    @Insert
    long insertTaskGetId(TaskEntity task);

    @Update
    void updateTasks(TaskEntity... tasks);

    @Delete
    void deleteTasks(TaskEntity... tasks);

    // TODO -- which Query should return a LiveData Object??

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    LiveData<List<TaskEntity>> loadAllTasks();

    @Query("SELECT * FROM task_table WHERE title = :title")
    List<TaskEntity> findTasksWithTitle(String title);

    @Query("SELECT * FROM task_table WHERE status = :status")
    List<TaskEntity> findTasksWithStatus(int status);

    @Query("SELECT * FROM task_table WHERE start_at = :startAt ORDER BY datetime(start_at) ASC")
    List<TaskEntity> findTasksWithStartAt(OffsetDateTime startAt);

    @Query("SELECT * FROM task_table WHERE deadline = :deadline ORDER BY datetime(deadline) ASC")
    List<TaskEntity> findTasksWithDeadline(OffsetDateTime deadline);

    @Query("SELECT * FROM task_table WHERE deadline_warning = :deadlineWarning ORDER BY datetime(deadline_warning) ASC")
    List<TaskEntity> findTasksWithDeadlineWarning(OffsetDateTime deadlineWarning);

    @Query("SELECT * FROM task_table WHERE priority = :priority")
    List<TaskEntity> findTasksWithPriority(int priority);

    @Query("SELECT * FROM task_table WHERE confidentiality = :confidentiality")
    List<TaskEntity> findTasksWithConfidentiality(int confidentiality);

    @Query("SELECT * FROM task_table WHERE trash = 1")
    List<TaskEntity> findTasksInTrash();

    @Query("SELECT * FROM task_table WHERE list_id = :listId")
    List<TaskEntity> findTasksByList(int listId);


}
