package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.Lawn;
import com.etlsolutions.javafx.data.area.subarea.Pond;
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
public class GardenArea extends Area {

    private ObservableList<PlantBed> plantBeds;
    private ObservableList<RaisedPlantBed> raisedPlantBeds;
    private ObservableList<Lawn> lawns;
    private ObservableList<Border> borders;
    private ObservableList<Greenhouse> greenhouses;
    private ObservableList<ContainerSet> containerSets;
    private ObservableList<SingleContainer> singleContainers;
    private ObservableList<Pond> ponds;
    private ObservableList<CustomSubArea> customSubareas;

    public GardenArea() {

    }

    protected GardenArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaShape shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, shape);
        plantBeds = new ObservableListWrapperA<>();
        raisedPlantBeds = new ObservableListWrapperA<>();
        lawns = new ObservableListWrapperA<>();
        borders = new ObservableListWrapperA<>();
        greenhouses = new ObservableListWrapperA<>();
        containerSets = new ObservableListWrapperA<>();
        singleContainers = new ObservableListWrapperA<>();
        ponds = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
    }

    public ObservableList<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableList<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableList<Lawn> getLawns() {
        return lawns;
    }

    public ObservableList<Border> getBorders() {
        return borders;
    }

    public ObservableList<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<Pond> getPonds() {
        return ponds;
    }

    public ObservableList<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {

        allSubAreas.clear();
        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(lawns);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(ponds);
        allSubAreas.addAll(customSubareas);
    }

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(PLANT_BED, RAISED_PLANT_BED, LAWN, BORDER, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, POND, CUSTOM);
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
            case LAWN:
                subAreas.addAll(lawns);
                break;

            case BORDER:
                subAreas.addAll(borders);
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
            case POND:
                subAreas.addAll(ponds);
                break;

            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.GARDEN;
    }
}
