package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The AllotmentArea class represents an allotment.
 *
 * @author zc
 */
public class AllotmentArea extends Area {

    private ObservableList<PlantBed> plantBeds;
    private ObservableList<RaisedPlantBed> raisedPlantBeds;
    private ObservableList<Border> borders;
    private ObservableList<Greenhouse> greenhouses;
    private ObservableList<CustomSubArea> customSubareas;

    public AllotmentArea() {

    }

    protected AllotmentArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {

        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
        plantBeds = new ObservableListWrapperA<>();
        raisedPlantBeds = new ObservableListWrapperA<>();
        borders = new ObservableListWrapperA<>();
        greenhouses = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
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

    public ObservableList<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {

        allSubAreas.clear();
        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(customSubareas);
    }

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(PLANT_BED, RAISED_PLANT_BED, BORDER, GREEN_HOUSE, CUSTOM);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {

        ObservableList<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case PLANT_BED:
                subAreas.addAll(plantBeds);
                break;
            case RAISED_PLANT_BED:
                subAreas.addAll(raisedPlantBeds);
                break;

            case BORDER:
                subAreas.addAll(borders);
                break;

            case GREEN_HOUSE:
                subAreas.addAll(greenhouses);
                break;

            case CUSTOM:
                subAreas.addAll(plantBeds);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return ALLOTMENT;
    }
}
