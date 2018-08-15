package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class AreaRoot extends DataUnit {

  private List<GardenArea> gardenAreas;
  private List<IndoorArea> indoorAreas;
  private List<PatioArea> patioAreas;
  private List<BalconyArea> balconyAreas;
  private List<AllotmentArea> allotmentAreas;
  private List<CustomArea> customAreas;
  
  public AreaRoot() {
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
  
  @Override
  public AreaRoot createInitialisedInstance() {
    AreaRoot a = new AreaRoot();
    a.setAllotmentAreas(new ArrayList<AllotmentArea>());
    a.setBalconyAreas(new ArrayList<BalconyArea>());
    a.setCustomAreas(new ArrayList<CustomArea>());
    a.setGardenAreas(new ArrayList<GardenArea>());
    a.setIndoorAreas(new ArrayList<IndoorArea>());
    a.setPatioAreas(new ArrayList<PatioArea>());
    return a;
  }  
}
