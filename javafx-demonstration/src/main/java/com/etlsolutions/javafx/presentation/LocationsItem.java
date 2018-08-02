package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 */
public class LocationsItem implements Item {

  private final LocationSubgroupItem parent;
  
  private String title;
  private String referencePosition; //Such as central, northeast corner, center of north border etc.
  private double distance;
  private String uom;
  private String direction;
  private String description;
  private String selectedImgLink;
  private String[] imgLinks = {};

  public LocationsItem(LocationSubgroupItem parent) {
    this.parent = parent;
  }
  
}
