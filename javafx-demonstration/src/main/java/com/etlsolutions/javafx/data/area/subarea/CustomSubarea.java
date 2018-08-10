package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class CustomSubarea extends Subarea {
  
  private List<CustomLocation> locations = new ArrayList<>();

  public List<CustomLocation> getLocations() {
    return new ArrayList<>(locations);
  }

  public void setLocations(List<CustomLocation> locations) {
    this.locations = new ArrayList<>(locations);
  }
         
}
