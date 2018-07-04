/*
 * Created by Ahmed Karim on 01/07/18 16:07
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/07/18 16:07
 */

package com.onadasoft.tasksetgo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.onadasoft.tasksetgo.db.entity.SubTaskEntity;

import java.util.List;

@Dao
public interface SubTaskDao {

    @Insert
    void insertSubTask(SubTaskEntity subTask);

    @Insert
    void insertAllSubTasks(List<SubTaskEntity> subTasks);

    @Insert
    long insertSubTaskGetId(SubTaskEntity subTask);

    @Update
    void updateSubTasks(SubTaskEntity... subTasks);

    @Delete
    void deleteSubTasks(SubTaskEntity... subTasks);

    @Query("SELECT * FROM subtask_table")
    List<SubTaskEntity> loadSubTasks();

    @Query("SELECT * FROM subtask_table WHERE task_id = :taskId")
    List<SubTaskEntity> loadSubTasksWithTaskId(int taskId);
}
