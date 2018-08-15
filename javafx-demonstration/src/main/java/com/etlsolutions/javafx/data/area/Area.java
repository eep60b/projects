package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public abstract class Area extends DataUnit {

  @JsonIgnore
  public static final String LONGGITUDE_PROPERTY = "com.etlsolutions.javafx.data.area.Area.LONGGITUDE_PROPERTY";
  @JsonIgnore
  public static final String LATITUTE_PROPERTY = "com.etlsolutions.javafx.data.area.Area.LATITUTE_PROPERTY";
  
  private double longitude;
  private double latitude;

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    double oldValue = this.longitude;
    this.longitude = longitude;
    fireChange(LONGGITUDE_PROPERTY, oldValue, this.longitude);
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    double oldValue = this.latitude;
    this.latitude = latitude;
    fireChange(LATITUTE_PROPERTY, oldValue, this.latitude);
  }
}
