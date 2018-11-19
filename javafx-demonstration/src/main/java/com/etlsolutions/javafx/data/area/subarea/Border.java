package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.BorderLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;
import static javax.swing.Spring.width;
import static jdk.nashorn.internal.objects.NativeRegExpExecResult.length;

/**
 *
 * @author zc
 */
public class Border extends SubArea {

    @JsonIgnore
    public static final String LENGTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.LENGTH_PROPERTY";
    @JsonIgnore
    public static final String WIDTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.WIDTH_PROPERTY";

    private ObservableListWrapperA<BorderLocation> locations;

    public Border() {
    }

    public Border(BorderMeasurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.locations = new ObservableListWrapperA<BorderLocation>();
    }

    public ObservableListWrapperA<BorderLocation> getLocations() {
        return locations;
    }

    public void setLocations(ObservableListWrapperA<BorderLocation> locations) {
        this.locations = locations;
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
