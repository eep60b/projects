package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class LogFactory {

    private static final LogFactory INSTANCE = new LogFactory();
    
    public static LogFactory getInstance() {
        return INSTANCE;
    }
    
    public Notification getDefaultNotification() {
        
        return new Notification(30, NotificationTimeUnit.MINUTS, 1);
    }
    
    public LogGroupRoot createLogGroupRoot() {

        LogGroupRoot l = new LogGroupRoot();

        l.setEvents(createEvents());
        l.setIssues(createIssues());
        l.setNotes(createNotes());
        l.setReferences(createReferences());
        l.setTasks(createTasks());
        l.setTests(createTests());
        l.setWeatherRecords(createWeatherRecords());
        return l;
    }

    public static Gvents createEvents() {

        return new Gvents("Events", "");

    }

    public static Issues createIssues() {
        return new Issues("Issues", "");

    }

    public static Notes createNotes() {

        return new Notes("Notes", "");
    }

    public static References createReferences() {
        
        return new References("References", "");
    }

    public static Tasks createTasks() {
        
        return new Tasks("Tasks", "");
    }

    public static Tests createTests() {
        
        return new Tests("Tests", "");
    }

    public static WeatherRecords createWeatherRecords() {
        
        return new WeatherRecords("Weather", "");
    }

    public static GrowingIssue createGrowingIssue(String title, String information, LocalDateTime startTime, LocalDateTime endTime, String solution, String effectiveness) {
        GrowingIssue g = new GrowingIssue(title, information, startTime, endTime, solution, effectiveness);
        return g;
    }

    public static GrowingObservation createGrowingObservation(String title, String information, LocalDateTime startTime, LocalDateTime endTime) {
        GrowingObservation g = new GrowingObservation(title, information, startTime, endTime);
        return g;
    }
    
    
    
}
