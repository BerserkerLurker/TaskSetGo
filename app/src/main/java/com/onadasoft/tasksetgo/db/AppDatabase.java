/*
 * Created by Ahmed Karim on 01/07/18 21:02
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/07/18 21:02
 */

package com.onadasoft.tasksetgo.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.onadasoft.tasksetgo.concurrence.AppExecutors;
import com.onadasoft.tasksetgo.db.converter.DateConverter;
import com.onadasoft.tasksetgo.db.dao.ListDao;
import com.onadasoft.tasksetgo.db.dao.SubTaskDao;
import com.onadasoft.tasksetgo.db.dao.TaskDao;
import com.onadasoft.tasksetgo.db.entity.ListEntity;
import com.onadasoft.tasksetgo.db.entity.SubTaskEntity;
import com.onadasoft.tasksetgo.db.entity.TaskEntity;

import java.util.List;

@Database(entities = {ListEntity.class, TaskEntity.class, SubTaskEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase sInstance;

    public static final String DATABASE_NAME = "tasksetgo-database";


    public abstract ListDao listDao();
    public abstract TaskDao taskDao();
    public abstract SubTaskDao subTaskDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors){
        if (sInstance == null){
            synchronized (AppDatabase.class){
                if(sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */

    private static AppDatabase buildDatabase(final Context appContext, final AppExecutors executors){

        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                executors.diskIO().execute(() -> {
                    // Add a delay to simulate a long running operation
                    addDelay();
                    // Generate the data for pre-population
                    AppDatabase database = AppDatabase.getInstance(appContext, executors);

                    List<ListEntity> lists = DataGenerator.generateLists();
                    List<TaskEntity> tasks = DataGenerator.generateTasks(lists);
                    List<SubTaskEntity> subTasks = DataGenerator.generateSubTasks(tasks);

                    insertData(database, lists, tasks, subTasks);

                    // notify that the database was created abnd it's ready to be used
                    database.setDatabaseCreated();
                });
            }
        }).build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<ListEntity> lists,
                                   final List<TaskEntity> tasks, final List<SubTaskEntity> subTasks){
        database.runInTransaction(() -> {
            database.listDao().insertAllLists(lists);
            database.taskDao().insertAllTasks(tasks);
            database.subTaskDao().insertAllSubTasks(subTasks);
        });
    }

    private static void addDelay(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    public LiveData<Boolean> getDatabaseCreated(){
        return mIsDatabaseCreated;
    }
}
