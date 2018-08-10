package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.PlantBedBorder;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import java.util.ArrayList;
import java.util.List;

/**
 * The AllotmentArea class represents an allotment. It is a rectangle area which usually have borders.
 *
 * @author zc
 */
public class AllotmentArea extends Area {

  private double length;
  private double width;
  private String uom;
  private List<PlantBed> normalPlantBeds = new ArrayList<>();  
  private List<PlantBedBorder> borders = new ArrayList<>();
  private List<Greenhouse> greenhouses = new ArrayList<>();

}
