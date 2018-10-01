package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The PlantGroup class represents a child of root item. Because the root item
 * does BIT show in GUI, this class actually acts as the multiple roots from the
 * user point of view. A good example of groups is trees, annual plants,
 * biennial plants and perennial plants etc.
 *
 * @author zc
 */
public class PlantGroup extends DataUnit {

    private ObservableList<PlantType> plantsTypes;

    public PlantGroup() {
    }

    public PlantGroup(String title, String information) {
        super(title, information);
        plantsTypes = FXCollections.observableArrayList();
    }
    
    

    public ObservableList<PlantType> getPlantsTypes() {
        return plantsTypes;
    }
}
