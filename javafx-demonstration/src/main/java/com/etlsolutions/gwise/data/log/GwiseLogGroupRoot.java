package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.log.gvent.GwiseGvents;
import com.etlsolutions.gwise.data.log.task.GwiseTasks;
import com.etlsolutions.gwise.data.log.weather.GwiseWeatherRecords;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRoot extends LogItem {
  
   private GwiseGvents events;
   private GwiseIssues issues;
   private GwiseNotes notes;
   private GwiseReferences references;
   private GwiseTasks tasks;
   private GwiseTests tests;
   private GwiseWeatherRecords weatherRecords;

    public GwiseLogGroupRoot(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseLogGroupRoot(GwiseLogGroupRootBean bean) {
        super(bean);
    }

    public GwiseGvents getGvents() {
        return events;
    }

    public void setEvents(GwiseGvents events) {
        this.events = events;
    }

    public GwiseIssues getIssues() {
        return issues;
    }

    public void setIssues(GwiseIssues issues) {
        this.issues = issues;
    }

    public GwiseNotes getNotes() {
        return notes;
    }

    public void setNotes(GwiseNotes notes) {
        this.notes = notes;
    }

    public GwiseReferences getReferences() {
        return references;
    }

    public void setReferences(GwiseReferences references) {
        this.references = references;
    }

    public GwiseTasks getTasks() {
        return tasks;
    }

    public void setTasks(GwiseTasks tasks) {
        this.tasks = tasks;
    }

    public GwiseTests getTests() {
        return tests;
    }

    public void setTests(GwiseTests tests) {
        this.tests = tests;
    }

    public GwiseWeatherRecords getWeatherRecords() {
        return weatherRecords;
    }

    public void setWeatherRecords(GwiseWeatherRecords weatherRecords) {
        this.weatherRecords = weatherRecords;
    }

    @Override
    public GwiseLogGroupRootBean getBean() {
        return new GwiseLogGroupRootBean(this);
    }
}
