package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PlantGroupRoot extends DataUnit {

  private final ObservableList<PlantGroup> plantGroups;

    public PlantGroupRoot() {
        plantGroups = FXCollections.observableArrayList();
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }
}
