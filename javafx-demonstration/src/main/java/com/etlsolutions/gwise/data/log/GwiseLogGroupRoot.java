package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.javafx.data.log.Issues;
import com.etlsolutions.javafx.data.log.Notes;
import com.etlsolutions.javafx.data.log.References;
import com.etlsolutions.javafx.data.log.Tests;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogGroupRoot extends LogItem {
  
   private Gvents events;
   private Issues issues;
   private Notes notes;
   private References references;
   private Tasks tasks;
   private Tests tests;
   private WeatherRecords weatherRecords;

    public GwiseLogGroupRoot(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public GwiseLogGroupRoot(GwiseLogGroupRootBean bean) {
        super(bean);
    }

   
   
   
    public Gvents getGvents() {
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

    @Override
    public GwiseLogGroupRootBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
