package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author zc
 */
public class LogFactory {

    public static LogGroupRoot createLogGroupRoot() {

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

        Gvents e = new Gvents();
        e.setTitle("Events");
        return e;
    }

    public static Issues createIssues() {
        Issues i = new Issues();
        i.setTitle("Issues");
        return i;
    }

    public static Notes createNotes() {

        Notes n = new Notes();
        n.setTitle("Notes");
        return n;
    }

    public static References createReferences() {
        References r = new References();
        r.setTitle("References");
        return r;
    }

    public static Tasks createTasks() {
        Tasks t = new Tasks();
        t.setTitle("Tasks");
        return t;
    }

    public static Tests createTests() {
        Tests t = new Tests();
        t.setTitle("Tests");
        return t;
    }

    public static WeatherRecords createWeatherRecords() {
        WeatherRecords w = new WeatherRecords();
        w.setTitle("Weather");
        return w;
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
