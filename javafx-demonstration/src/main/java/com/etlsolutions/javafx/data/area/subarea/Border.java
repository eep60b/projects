package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 * The border will be only created by right click a subarea. It will be changed when the subarea changed.
 *
 * @author zc
 */
public class Border extends SubArea {

    public Border() {
    }

    public Border(BorderMeasurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.locations = new ObservableListWrapperA<>();
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.BORDER;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {

        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case BORDER_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.BORDER_LOCATION);
    }
}
