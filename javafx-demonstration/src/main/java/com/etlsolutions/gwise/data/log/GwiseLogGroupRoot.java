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
    
    private final GwiseGvents events;
    private final GwiseIssues issues;
    private final GwiseNotes notes;
    private final GwiseReferences references;
    private final GwiseTasks tasks;
    private final GwiseTests tests;
    private final GwiseWeatherRecords weatherRecords;
    
    public GwiseLogGroupRoot(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
            GwiseGvents events, GwiseIssues issues, GwiseNotes notes, GwiseReferences references, GwiseTasks tasks, GwiseTests tests, GwiseWeatherRecords weatherRecords) {
        
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.events = events;
        this.issues = issues;
        this.notes = notes;
        this.references = references;
        this.tasks = tasks;
        this.tests = tests;
        this.weatherRecords = weatherRecords;
    }
    
    public GwiseLogGroupRoot(GwiseLogGroupRootBean bean) {
        super(bean);
        events = new GwiseGvents(bean.getEvents());
        issues = new GwiseIssues(bean.getIssues());
        notes = new GwiseNotes(bean.getNotes());
        references = new GwiseReferences(bean.getReferences());
        tasks = new GwiseTasks(bean.getTasks());
        tests = new GwiseTests(bean.getTests());
        weatherRecords = new GwiseWeatherRecords(bean.getWeatherRecords());
    }
    
    public GwiseGvents getGvents() {
        return events;
    }
    
    public GwiseIssues getIssues() {
        return issues;
    }
    
    public GwiseNotes getNotes() {
        return notes;
    }
    
    public GwiseReferences getReferences() {
        return references;
    }
    
    public GwiseTasks getTasks() {
        return tasks;
    }
    
    public GwiseTests getTests() {
        return tests;
    }
    
    public GwiseWeatherRecords getWeatherRecords() {
        return weatherRecords;
    }

    @Override
    public GwiseLogGroupRootBean getBean() {
        return new GwiseLogGroupRootBean(this);
    }
}
