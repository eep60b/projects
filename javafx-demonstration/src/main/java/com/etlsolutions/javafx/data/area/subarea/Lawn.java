package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Lawn extends SubArea {

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.LAWN;
    }

    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.CUSTOMER_LOCATION);
    }  
    
}
