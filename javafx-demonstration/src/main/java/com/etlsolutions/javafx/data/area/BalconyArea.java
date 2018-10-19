package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

    private ObservableList<ContainerSet> containerSets;
    private ObservableList<SingleContainer> singleContainers;
    private ObservableList<CustomSubArea> customSubareas;

    public BalconyArea() {
    }

    protected BalconyArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
        containerSets = new ObservableListWrapperA<>();
        singleContainers = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {
        
        allSubAreas.clear();
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(customSubareas);
    }
    
    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaType getType() {
        return AreaType.BALCONY;
    }
}
