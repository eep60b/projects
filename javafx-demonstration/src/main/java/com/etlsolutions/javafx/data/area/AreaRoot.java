package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class AreaRoot extends DataUnit {

  private List<GardenArea> gardenAreas = new ArrayList<>();
  private List<IndoorArea> indoorAreas = new ArrayList<>();
  private List<PatioArea> patioAreas = new ArrayList<>();
  private List<BalconyArea> balconyAreas = new ArrayList<>();
  private List<AllotmentArea> allotmentAreas = new ArrayList<>();
  private List<CustomArea> customAreas = new ArrayList<>();
  
  public AreaRoot() {
    super.setTitle("AreaRoot");
  }

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
