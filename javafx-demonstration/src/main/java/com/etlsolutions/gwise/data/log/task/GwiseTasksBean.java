package com.etlsolutions.gwise.data.log.task;

import com.etlsolutions.gwise.data.log.GwiseLogGroupBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseTasksBean  extends GwiseLogGroupBean {
  
    public List<GwiseTask> tasks = new ArrayList<>();

    public GwiseTasksBean() {
    }

    public GwiseTasksBean(GwiseTasks tasks) {
        super(tasks);
    }


    public List<GwiseTask> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<GwiseTask> tests) {
        this.tasks = new ArrayList<>(tests);
  
    }
}