package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;

/**
 *
 * @author zc
 */
public abstract class Area extends DataUnit {

  private double longitude = -1;
  private double latitude = -1;

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
}
