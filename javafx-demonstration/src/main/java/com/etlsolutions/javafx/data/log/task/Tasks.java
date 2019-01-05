package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.LogGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class Tasks  extends LogGroup {
  
    public static final String TASKS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TASKS_PROPERTY";
    public List<Tasks> tasks = new ArrayList<>();

    public Tasks() {
    }

    public Tasks(String title) {
        super(title);
    }

    public List<Tasks> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<Tasks> tests) {
        this.tasks = new ArrayList<>(tests);
        fireChange(TASKS_PROPERTY);
    }

}