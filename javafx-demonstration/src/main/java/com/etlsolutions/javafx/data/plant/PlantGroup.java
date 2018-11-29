package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
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

    private ObservableListWrapperA<PlantSubGroup> plantsSubGroups;

    public PlantGroup() {
    }

    public PlantGroup(DataUnitValueWrapper valueWrapper, ObservableListWrapperA<PlantSubGroup> plantsSubGroups) {
        super(valueWrapper);
        this.plantsSubGroups = plantsSubGroups;
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantsSubGroups() {
        return plantsSubGroups;
    }

    public void setPlantsSubGroups(ObservableListWrapperA<PlantSubGroup> plantsSubGroups) {
        this.plantsSubGroups = plantsSubGroups;
    }
}
