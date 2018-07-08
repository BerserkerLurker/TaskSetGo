/*
 * Created by Ahmed Karim on 04/07/18 12:52
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 04/07/18 12:52
 */

package com.onadasoft.tasksetgo.db;


import com.onadasoft.tasksetgo.db.entity.ListEntity;
import com.onadasoft.tasksetgo.db.entity.SubTaskEntity;
import com.onadasoft.tasksetgo.db.entity.TaskEntity;

import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates data to pre-populate the database
 */
public class DataGenerator {

    /*
    private static final int RED    = 0;
    private static final int PINK   = 1;
    private static final int PURPLE = 2;
    private static final int BLUE   = 3;
    private static final int CYAN   = 4;
    private static final int TEAL   = 5;
    private static final int GREEN  = 6;
    private static final int AMBER  = 7;
    private static final int ORANGE = 8;
    */
    private static final String[] sColors=  {"Red",
                                             "Pink",
                                             "Purple",
                                             "Blue",
                                             "Cyan",
                                             "Teal",
                                             "Green",
                                             "Amber",
                                             "Orange"};

    private static final String[] MOCK1 = new String[]{
            "Special", "New", "Great", "Normal", "Used"};

    private static final String[] MOCK2 = new String[]{
            "Day", "Task", "Job", "Errand", "Reminder"};

    private static final String[] MOCK3 = new String[]{
            "Monastir", "Sousse", "Tunis", "Mahdia", "Nabeul"};

    public static List<ListEntity> generateLists(){
        List<ListEntity> lists = new ArrayList<>(9);
        for (int i = 0; i < 9; i++){
            ListEntity list = new ListEntity();
            list.setId(i+1);
            list.setColor(i);
            list.setName(sColors[i]);
            lists.add(list);
        }
        return lists;
    }

    public static List<TaskEntity> generateTasks(final List<ListEntity> lists){

        List<TaskEntity> tasks = new ArrayList<>();
        Random random = new Random();

        for (ListEntity list : lists){
            int tasksNumber = random.nextInt(5) + 1;
            for(int i = 0; i < tasksNumber; i++){
                TaskEntity task = new TaskEntity();
                task.setId(i+1);
                task.setListId(list.getId());
                // subtasks are 0 by default ??
                task.setNumberSubtasks(random.nextInt(4));

                task.setTitle(list.getName() + ": "
                        + MOCK1[random.nextInt(MOCK1.length)] + " "
                        + MOCK2[random.nextInt(MOCK2.length)]);

                task.setDescription("Random description");
                task.setLocation(MOCK3[random.nextInt(MOCK3.length)]);
                task.setStatus(random.nextInt(4));
                task.setProgress(random.nextInt(11)*10);
                task.setPriority(random.nextInt(4));

                // TODO -- enhance logic for testing
                task.setStartAt(OffsetDateTime.now());
                int dLineAdd = random.nextInt(32);
                task.setDeadline(OffsetDateTime.now().plusDays(dLineAdd));
                task.setDeadlineWarning(OffsetDateTime.now().plusDays(dLineAdd-1));

                task.setConfidentiality(random.nextInt(4));
                task.setUrl("https://github.com/BerserkerLurker");

                task.setTrash(0);

                tasks.add(task);
            }
        }
        return tasks;

    }

    public static List<SubTaskEntity> generateSubTasks(final List<TaskEntity> tasks){

        List<SubTaskEntity> subTasks = new ArrayList<>();
        Random random = new Random();

        for (TaskEntity task : tasks){
            int nbSubTasks = task.getNumberSubtasks();
            if (nbSubTasks > 0){
                for(int i = 0; i < nbSubTasks; i++){
                    SubTaskEntity subTask = new SubTaskEntity();
                    subTask.setId(i+1);
                    subTask.setTaskId(task.getId());
                    subTask.setTitle(MOCK2[random.nextInt(MOCK2.length)]);

                    subTasks.add(subTask);
                }
            }
        }
        return subTasks;
    }
}














