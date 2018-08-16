package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantBedLocation extends Location {

  private String referentialPosition; //Such as central, northeast corner, center of north border etc.
  private double distance;
  private double occupiedArea;
  private String uom;
  private String direction;
  private String description;
  private String[] imgLinks = {};
  private String[] imgInfos = {};
  private int selectedImgLink;

  public List<String> getDefaultReferentialPositions() {
    return Arrays.asList("central", "northeast corner", "northwest corner", "southeast corner", "southwest corner");
  }
  
}
