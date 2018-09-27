package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.CustomSubAreaK;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public static final String RAISED_PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.RAISED_PLANT_BEDS_PROPERTY";
    @JsonIgnore
    public static final String BORDERS_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.BORDERS_PROPERTY";
    @JsonIgnore
    public static final String GREENHOUSES_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.GREENHOUSES_PROPERTY";
    @JsonIgnore
    public static final String CUSTOM_SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.AllotmentArea.CUSTOM_SUBAREAS_PROPERTY";

    private double length;
    private double width;
    private String uom;
    private final ObservableList<PlantBed> plantBeds;
    private final ObservableList<RaisedPlantBed> raisedPlantBeds;
    private final ObservableList<Border> borders;
    private final ObservableList<Greenhouse> greenhouses;
    private final ObservableList<CustomSubAreaK> customSubareas;

    public AllotmentArea() {
        this.plantBeds = FXCollections.observableArrayList();
        this.raisedPlantBeds = FXCollections.observableArrayList();
        this.borders = FXCollections.observableArrayList();
        this.greenhouses = FXCollections.observableArrayList();
        this.customSubareas = FXCollections.observableArrayList();
    }

    AllotmentArea(double length, double width, String uom) {
        this();
        this.length = length;
        this.width = width;
        this.uom = uom;
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

    public ObservableList<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableList<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableList<Border> getBorders() {
        return borders;
    }

    public ObservableList<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableList<CustomSubAreaK> getCustomSubareas() {
        return customSubareas;
    }
    
    @Override
    public void updateAllSubAreas() {
        List<SubArea> subAreas = getAllSubAreas();
        subAreas.addAll(plantBeds);        
    }

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(SubAreaType.BORDER, SubAreaType.CUSTOM);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
