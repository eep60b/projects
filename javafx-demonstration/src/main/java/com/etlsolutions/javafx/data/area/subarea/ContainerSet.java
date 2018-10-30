package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public class ContainerSet extends SubArea {

    private Container container;
    private int number;

    public ContainerSet() {
    }

    public ContainerSet(Container container, int number, SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.container = container;
        this.number = number;
    }

    public ContainerSet(Container container, int number, SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.container = container;
        this.number = number;
    }


    
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(container);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CONTAINTER_SET;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        ObservableListWrapperA<Location> locations = new ObservableListWrapperA<>();
        switch(type){
            case CONTAINER:
                locations.add(container);
                break;
        }
        return locations;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CONTAINER);
    }
}
