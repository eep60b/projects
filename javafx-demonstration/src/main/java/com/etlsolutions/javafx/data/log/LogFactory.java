package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.log.event.Events;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
import java.util.ArrayList;
import java.util.Date;

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

    public static Events createEvents() {

        Events e = new Events();
        e.setTitle("Events");
        e.setYears(new ArrayList<LogYear>());
        return e;
    }

    public static Issues createIssues() {
        Issues i = new Issues();
        i.setTitle("Issues");
        i.setYears(new ArrayList<LogYear>());
        return i;
    }

    public static Notes createNotes() {

        Notes n = new Notes();
        n.setTitle("Notes");
        n.setYears(new ArrayList<LogYear>());
        return n;
    }

    public static References createReferences() {
        References r = new References();
        r.setTitle("References");
        r.setYears(new ArrayList<LogYear>());
        return r;
    }

    public static Tasks createTasks() {
        Tasks t = new Tasks();
        t.setTitle("Tasks");
        t.setYears(new ArrayList<LogYear>());
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
        w.setYears(new ArrayList<LogYear>());
        return w;
    }

    public static GrowingIssue createGrowingIssue() {
        GrowingIssue g = new GrowingIssue();
        g.setId(DataUnitIdRegistry.createNewId());
        g.setTitle("");
        g.setTime(new Date());
        g.setSolution("");
        g.setEffectiveness("");
        g.setInformation("");
        return g;
    }

    public static GrowingObservation createGrowingObservation() {
        GrowingObservation g = new GrowingObservation();
        g.setId(DataUnitIdRegistry.createNewId());
        g.setTitle("");
        g.setTime(new Date());
        g.setInformation("");
        return g;
    }
}
