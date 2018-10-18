package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PatioArea extends Area {

    private ObservableList<RaisedPlantBed> raisedPlantBeds;
    private ObservableList<Greenhouse> greenhouses;
    private ObservableList<SingleContainer> singleContainers;
    private ObservableList<ContainerSet> containerSets;
    private ObservableList<CustomSubArea> customSubareas;

    public PatioArea() {

    }

    public PatioArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {

        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
        raisedPlantBeds = new ObservableListWrapperA<>();
        greenhouses = new ObservableListWrapperA<>();
        singleContainers = new ObservableListWrapperA<>();
        containerSets = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
    }

    public ObservableList<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableList<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {
        
        allSubAreas.clear();
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(customSubareas);
    }

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(RAISED_PLANT_BED, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, CUSTOM);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {
               ObservableList<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case RAISED_PLANT_BED:
                subAreas.addAll(raisedPlantBeds);
                break;

            case GREEN_HOUSE:
                subAreas.addAll(greenhouses);
                break;

            case CONTAINTER_SET:
                subAreas.addAll(containerSets);
                break;

            case SINGLE_CONTAINTER:
                subAreas.addAll(singleContainers);
                break;
                
            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.PATIO;
    }
}
