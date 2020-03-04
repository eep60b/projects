package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.log.gvent.GwiseGventsBean;
import com.etlsolutions.javafx.data.log.Issues;
import com.etlsolutions.javafx.data.log.Notes;
import com.etlsolutions.javafx.data.log.References;
import com.etlsolutions.javafx.data.log.Tests;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRootBean extends LogItemBean {
  
   private GwiseGventsBean events;
   private Issues issues;
   private Notes notes;
   private References references;
   private Tasks tasks;
   private Tests tests;
   private WeatherRecords weatherRecords;

    public GwiseLogGroupRootBean() {
    }

    public GwiseLogGroupRootBean(GwiseGventsBean events, Issues issues, Notes notes, References references, Tasks tasks, Tests tests, WeatherRecords weatherRecords, LogItem item) {
        super(item);
        this.events = events;
        this.issues = issues;
        this.notes = notes;
        this.references = references;
        this.tasks = tasks;
        this.tests = tests;
        this.weatherRecords = weatherRecords;
    }

    public GwiseGventsBean getEvents() {
        return events;
    }

    public void setEvents(GwiseGventsBean events) {
        this.events = events;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Tests getTests() {
        return tests;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
    }

    public WeatherRecords getWeatherRecords() {
        return weatherRecords;
    }

    public void setWeatherRecords(WeatherRecords weatherRecords) {
        this.weatherRecords = weatherRecords;
    }
}
