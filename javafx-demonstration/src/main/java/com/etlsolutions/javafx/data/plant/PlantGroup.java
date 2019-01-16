package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 * The PlantGroup class represents a child of root item. Because the root item
 * does BIT show in GUI, this class actually acts as the multiple roots from the
 * user point of view. A good example of groups is trees, annual plants,
 * biennial plants and perennial plants etc.
 *
 * @author zc
 */
public class PlantGroup extends DataUnit {

    private ObservableListWrapperA<PlantSubGroup> plantSubGroups;

    public PlantGroup() {
    }

    public PlantGroup(PlantGroupValueWrapper valueWrapper) {
        super(valueWrapper);
        this.plantSubGroups = new ObservableListWrapperA<>(valueWrapper.getPlantsSubGroups());
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantSubGroups() {
        return plantSubGroups;
    }

    public void setPlantSubGroups(ObservableListWrapperA<PlantSubGroup> plantSubGroups) {
        this.plantSubGroups = plantSubGroups;
    }

    public void setValue(PlantGroupValueWrapper valueWrapper) {
        setCommonValues(valueWrapper);
        plantSubGroups.clear();
        plantSubGroups.addAll(valueWrapper.getPlantsSubGroups());
    }
}
