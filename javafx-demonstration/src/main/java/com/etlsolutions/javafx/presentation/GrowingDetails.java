package com.etlsolutions.javafx.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class GrowingDetails {

  private String description;
  private int lifeSpan = 1;
  private GrowingStartPoint startPoint;
  private Date startDate;
  private Date[] transplantDates;
  private List<GrowingIssue> growingIssues;
  private GrowingMedium medium;
  private List<GrowingFertiliserUsage> fertiliserUsage;
  private String support;
  private List<Flowering> flowerings = new ArrayList<>();
  private List<Fruiting> fruitings = new ArrayList<>();
  private List<Harvest> harvests = new ArrayList<>();  
}
