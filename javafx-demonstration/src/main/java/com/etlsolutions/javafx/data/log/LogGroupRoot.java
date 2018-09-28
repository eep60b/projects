package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;

/**
 *
 * @author zc
 */
public class LogGroupRoot extends DataUnit {
  
   private Gvents events;
   private Issues issues;
   private Notes notes;
   private References references;
   private Tasks tasks;
   private Tests tests;
   private WeatherRecords weatherRecords;

    public Gvents getEvents() {
        return events;
    }

    public void setEvents(Gvents events) {
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
