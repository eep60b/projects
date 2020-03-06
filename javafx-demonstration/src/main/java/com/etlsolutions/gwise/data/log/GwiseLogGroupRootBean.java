package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.log.gvent.GwiseGventsBean;
import com.etlsolutions.gwise.data.log.task.GwiseTasksBean;
import com.etlsolutions.gwise.data.log.weather.GwiseWeatherRecordsBean;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRootBean extends LogItemBean {
  
   private GwiseGventsBean events;
   private GwiseIssuesBean issues;
   private GwiseNotesBean notes;
   private GwiseReferencesBean references;
   private GwiseTasksBean tasks;
   private GwiseTestsBean tests;
   private GwiseWeatherRecordsBean weatherRecords;

    public GwiseLogGroupRootBean() {
    }

    public GwiseLogGroupRootBean(GwiseLogGroupRoot root) {
        super(root);
        events = new GwiseGventsBean(root.getGvents());
        issues = new GwiseIssuesBean(root.getIssues());
        notes = new GwiseNotesBean(root.getNotes());
        references = new GwiseReferencesBean(root.getReferences());
        tasks = new GwiseTasksBean(root.getTasks());
        tests = new GwiseTestsBean(root.getTests());
        weatherRecords = new GwiseWeatherRecordsBean(root.getWeatherRecords());
    }

    public GwiseGventsBean getEvents() {
        return events;
    }

    public void setEvents(GwiseGventsBean events) {
        this.events = events;
    }

    public GwiseIssuesBean getIssues() {
        return issues;
    }

    public void setIssues(GwiseIssuesBean issues) {
        this.issues = issues;
    }

    public GwiseNotesBean getNotes() {
        return notes;
    }

    public void setNotes(GwiseNotesBean notes) {
        this.notes = notes;
    }

    public GwiseReferencesBean getReferences() {
        return references;
    }

    public void setReferences(GwiseReferencesBean references) {
        this.references = references;
    }

    public GwiseTasksBean getTasks() {
        return tasks;
    }

    public void setTasks(GwiseTasksBean tasks) {
        this.tasks = tasks;
    }

    public GwiseTestsBean getTests() {
        return tests;
    }

    public void setTests(GwiseTestsBean tests) {
        this.tests = tests;
    }

    public GwiseWeatherRecordsBean getWeatherRecords() {
        return weatherRecords;
    }

    public void setWeatherRecords(GwiseWeatherRecordsBean weatherRecords) {
        this.weatherRecords = weatherRecords;
    }
}
