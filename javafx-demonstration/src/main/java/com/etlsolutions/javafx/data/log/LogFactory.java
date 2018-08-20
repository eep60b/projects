package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.log.event.Events;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
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

    private static References createReferences() {
        References r = new References();
        r.setTitle("References");
        r.setYears(new ArrayList<LogYear>());
        return r;
    }

    private static Tasks createTasks() {
        Tasks t = new Tasks();
        t.setTitle("Tasks");
        t.setYears(new ArrayList<LogYear>());
        return t;
    }

    private static Tests createTests() {
        Tests t = new Tests();
        t.setTitle("Tests");
        return t;
    }

    private static WeatherRecords createWeatherRecords() {
        WeatherRecords w = new WeatherRecords();
        w.setTitle("Weather");
        w.setYears(new ArrayList<LogYear>());
        return w;
    }
    
}
