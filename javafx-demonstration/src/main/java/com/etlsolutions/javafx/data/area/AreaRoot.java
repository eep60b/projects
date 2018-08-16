package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class AreaRoot extends DataUnit {

  @JsonIgnore
  public static final String GARDENAREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.GARDENAREA_PROPERTY";
  @JsonIgnore
  public static final String INDOORAREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.INDOORAREA_PROPERTY";
  @JsonIgnore
  public static final String PATIOREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.PATIOREA_PROPERTY";
  @JsonIgnore
  public static final String BALCONYAREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.BALCONYAREA_PROPERTY";
  @JsonIgnore
  public static final String ALLOTMENTAREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.ALLOTMENTAREA_PROPERTY";
  @JsonIgnore
  public static final String CUSTOMAREA_PROPERTY = "com.etlsolutions.javafx.data.area.AreaRoot.CUSTOMAREA_PROPERTY";

  private List<GardenArea> gardenAreas;
  private List<IndoorArea> indoorAreas;
  private List<PatioArea> patioAreas;
  private List<BalconyArea> balconyAreas;
  private List<AllotmentArea> allotmentAreas;
  private List<CustomArea> customAreas;

  public List<GardenArea> getGardenAreas() {
    return gardenAreas;
  }

  public void setGardenAreas(List<GardenArea> gardenAreas) {
    this.gardenAreas = gardenAreas;
  }

  public List<IndoorArea> getIndoorAreas() {
    return indoorAreas;
  }

  public void setIndoorAreas(List<IndoorArea> indoorAreas) {
    this.indoorAreas = indoorAreas;
  }

  public List<PatioArea> getPatioAreas() {
    return patioAreas;
  }

  public void setPatioAreas(List<PatioArea> patioAreas) {
    this.patioAreas = patioAreas;
  }

  public List<BalconyArea> getBalconyAreas() {
    return balconyAreas;
  }

  public void setBalconyAreas(List<BalconyArea> balconyAreas) {
    this.balconyAreas = balconyAreas;
  }

  public List<AllotmentArea> getAllotmentAreas() {
    return allotmentAreas;
  }

  public void setAllotmentAreas(List<AllotmentArea> allotmentAreas) {
    this.allotmentAreas = allotmentAreas;
  }

  public List<CustomArea> getCustomAreas() {
    return customAreas;
  }

  public void setCustomAreas(List<CustomArea> customAreas) {
    this.customAreas = customAreas;
  }
}
