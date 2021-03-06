package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 * The ContainerSet c
 * @author zc
 */
public class ContainerSet extends SubArea {

    private Container container;

    public ContainerSet() {
    }

    public ContainerSet(Container container, ContainerSetMeasurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.container = container;
    }
    
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
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
