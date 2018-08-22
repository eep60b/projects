package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.PlantBedBorder;
import com.etlsolutions.javafx.data.area.subarea.Subarea;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
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
    AllotmentArea a = new AllotmentArea(10, 5, "meter", new ArrayList<PlantBed>(), new ArrayList<PlantBedBorder>(), new ArrayList<Greenhouse>());
    return a;
  }
  
  public static BalconyArea createBalconyArea() {
    BalconyArea a = new BalconyArea();
    a.setTitle("Untitled");
    a.setImgLinks(new ArrayList<ImageLink>());
    a.setContainers(new ArrayList<Container>());
    return a;
  }  
  
  public static CustomArea createCustomArea() {
    CustomArea a = new CustomArea();
    a.setTitle("Untitled");
    a.setImgLinks(new ArrayList<ImageLink>());
    a.setSubareas(new ArrayList<Subarea>());
    return a;
  }  
}
