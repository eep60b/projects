package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.PlantBedBorder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 * The AllotmentArea class represents an allotment. It is a rectangle area which usually have borders.
 *
 * @author zc
 */
public class AllotmentArea extends Area {

  @JsonIgnore
  public static final String LENGTH_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.LENGTH_PROPERTY";
  @JsonIgnore
  public static final String WIDTH_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.WIDTH_PROPERTY";
  @JsonIgnore
  public static final String UOM_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.UOM_PROPERTY";
  @JsonIgnore
  public static final String PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.PLANT_BEDS_PROPERTY";
  @JsonIgnore
  public static final String BORDERS_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.BORDERS_PROPERTY";
  @JsonIgnore
  public static final String GREENHOUSES_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.GREENHOUSES_PROPERTY";

  private double length;
  private double width;
  private String uom;
  private List<PlantBed> plantBeds;
  private List<PlantBedBorder> borders;
  private List<Greenhouse> greenhouses;

  public AllotmentArea() {
  }

  private AllotmentArea(double length, double width, String uom, List<PlantBed> plantBeds, List<PlantBedBorder> borders, List<Greenhouse> greenhouses) {
    this.length = length;
    this.width = width;
    this.uom = uom;
    this.plantBeds = plantBeds;
    this.borders = borders;
    this.greenhouses = greenhouses;
  }

  @Override
  public DataUnit createInitialisedInstance() {
    return new AllotmentArea(10, 5, "meter", new ArrayList<PlantBed>(), new ArrayList<PlantBedBorder>(), new ArrayList<Greenhouse>());
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    double oldValue = this.length;
    this.length = length;
    fireChange(LENGTH_PROPERTY, oldValue, this.length);
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    double oldValue = this.width;
    this.width = width;
    fireChange(WIDTH_PROPERTY, oldValue, this.width);
  }

  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    String oldValue = this.uom;
    this.uom = uom;
    fireChange(UOM_PROPERTY, oldValue, this.uom);
  }

  public List<PlantBed> getPlantBeds() {
    return new ArrayList<>(plantBeds);
  }

  public boolean addPlantBed(PlantBed plantBed) {
    boolean added = plantBeds.add(plantBed);
    fireChange(PLANT_BEDS_PROPERTY, false, added);
    return added;
  }

  public boolean removePlantBed(PlantBed plantBed) {
    boolean removed = plantBeds.remove(plantBed);
    fireChange(PLANT_BEDS_PROPERTY, false, removed);
    return removed;
  }
  
  public List<PlantBedBorder> getBorders() {
    return new ArrayList<>(borders);
  }

  public boolean addBorders(PlantBedBorder border) {
    boolean added = borders.add(border);
    fireChange(BORDERS_PROPERTY, false, added);
    return added;
  }

  public boolean removeBorders(PlantBedBorder border) {
    boolean removed = borders.remove(border);
    fireChange(BORDERS_PROPERTY, false, removed);
    return removed;
  }
  
  public List<Greenhouse> getGreenhouses() {
    return new ArrayList<>(greenhouses);
  }

  public boolean addGreenhouses(Greenhouse greenhous) {
    boolean added = greenhouses.add(greenhous);
    fireChange(GREENHOUSES_PROPERTY, false, added);
    return added;
  }

  public boolean removeGreenhouses(Greenhouse greenhous) {
    boolean removed = greenhouses.remove(greenhous);
    fireChange(GREENHOUSES_PROPERTY, false, removed);
    return removed;
  }
}
