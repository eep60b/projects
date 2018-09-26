package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Container set, border area, raised-bed, normal-plant-bed
 *
 * @author zc
 */
public abstract class SubAreaK extends DataUnit {

    protected final ObservableList<Location> allLocations;

    public SubAreaK() {
        allLocations = FXCollections.observableArrayList();
    }
    
    public abstract void updateAllLocations();

    public abstract SubAreaType getType();

    public ObservableList<Location> getAllLocations() {
        return allLocations;
    }
}
