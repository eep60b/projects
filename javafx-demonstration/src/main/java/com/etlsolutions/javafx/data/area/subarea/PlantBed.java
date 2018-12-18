package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation;

/**
 *
 * @author zc
 */
public class PlantBed extends SubArea {

    public PlantBed() {
    }

    public PlantBed(Measurement measurement, DataUnitValueWrapper valueWrapper) {
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
        return SubAreaType.PLANT_BED;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case PLANT_BED_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }
    
        @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.PLANT_BED_LOCATION);
    }
}
