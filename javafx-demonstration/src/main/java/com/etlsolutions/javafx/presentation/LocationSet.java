package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 */
public class LocationSet implements Item {

  private final LocationSubgroupItem parent;
  
  private String title;
  private String referentialPosition; //Such as central, northeast corner, center of north border etc.
  private double distance;
  private double area;
  private String uom;
  private String direction;
  private String description;
  private String[] imgLinks = {};
  private String[] imgInfos = {};
  private int selectedImgLink;

  public LocationSet(LocationSubgroupItem parent) {
    this.parent = parent;
  }
  
}
