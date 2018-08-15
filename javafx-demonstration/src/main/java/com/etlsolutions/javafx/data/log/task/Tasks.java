package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class Tasks  extends DataUnit {
  
    public static final String TASKS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TASKS_PROPERTY";
    public List<Tasks> tasks = new ArrayList<>();

    public Tasks() {
        super.setTitle("Tasks");
    }

    public List<Tasks> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<Tasks> tests) {
        this.tasks = new ArrayList<>(tests);
        fireChange(TASKS_PROPERTY);
    }

  @Override
  public DataUnit createInitialisedInstance() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}