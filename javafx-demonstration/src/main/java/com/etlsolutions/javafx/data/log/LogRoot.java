package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.event.Events;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;

/**
 *
 * @author zc
 */
public class LogRoot extends DataUnit {
  
   private final Events events = new Events();
   private final Issues issues = new Issues();
   private final Notes notes = new Notes();
   private final Tasks tasks = new Tasks();
   private final Tests tests = new Tests();
   private final WeatherRecords weatherRecords = new WeatherRecords();

  public Events getEvents() {
    return events;
  }

  public Issues getIssues() {
    return issues;
  }

  public Notes getNotes() {
    return notes;
  }

  public Tasks getTasks() {
    return tasks;
  }

  public Tests getTests() {
    return tests;
  }

  public WeatherRecords getWeatherRecords() {
    return weatherRecords;
  }

  @Override
  public DataUnit createInitialisedInstance() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
