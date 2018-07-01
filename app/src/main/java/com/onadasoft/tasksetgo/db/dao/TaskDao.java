/*
 * Created by Ahmed Karim on 01/07/18 14:21
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/07/18 14:21
 */

package com.onadasoft.tasksetgo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.onadasoft.tasksetgo.db.entity.Task;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Insert
    long insertTaskGetId(Task task);

    @Update
    void updateTasks(Task... tasks);

    @Delete
    void deleteTasks(Task... tasks);

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    List<Task> loadAllTasks();

    @Query("SELECT * FROM task_table WHERE title = :title")
    List<Task> findTasksWithTitle(String title);

    @Query("SELECT * FROM task_table WHERE status = :status")
    List<Task> findTasksWithStatus(int status);

    @Query("SELECT * FROM task_table WHERE start_at = :startAt ORDER BY datetime(start_at) ASC")
    List<Task> findTasksWithStartAt(OffsetDateTime startAt);

    @Query("SELECT * FROM task_table WHERE deadline = :deadline ORDER BY datetime(deadline) ASC")
    List<Task> findTasksWithDeadline(OffsetDateTime deadline);

    @Query("SELECT * FROM task_table WHERE deadline_warning = :deadlineWarning ORDER BY datetime(deadline_warning) ASC")
    List<Task> findTasksWithDeadlineWarning(OffsetDateTime deadlineWarning);

    @Query("SELECT * FROM task_table WHERE priority = :priority")
    List<Task> findTasksWithPriority(int priority);

    @Query("SELECT * FROM task_table WHERE confidentiality = :confidentiality")
    List<Task> findTasksWithConfidentiality(int confidentiality);

    @Query("SELECT * FROM task_table WHERE trash = 1")
    List<Task> findTasksInTrash();

    @Query("SELECT * FROM task_table WHERE list_id = :listId")
    List<Task> findTasksByList(int listId);


}
