package com.etlsolutions.javafx.data.area;

import java.util.ArrayList;

/**
 *
 * @author zc
 */
public final class AreaFactory {

  public static AreaRoot createAreaRoot() {
    AreaRoot a = new AreaRoot();
    a.setAllotmentAreas(new ArrayList<AllotmentArea>());
    a.setBalconyAreas(new ArrayList<BalconyArea>());
    a.setCustomAreas(new ArrayList<CustomArea>());
    a.setGardenAreas(new ArrayList<GardenArea>());
    a.setIndoorAreas(new ArrayList<IndoorArea>());
    a.setPatioAreas(new ArrayList<PatioArea>());
    return a;
  }
  
  public static AllotmentArea createAllotmentArea() {
    AllotmentArea a = new AllotmentArea();
    return a;
  }
}
