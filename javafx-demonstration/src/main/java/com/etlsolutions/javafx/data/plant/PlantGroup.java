package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The PlantGroup class represents a child of root item. Because the root item
 * does BIT show in GUI, this class actually acts as the multiple roots from the
 * user point of view. A good example of groups is trees, annual plants,
 * biennial plants and perennial plants etc.
 *
 * @author zc
 */
public class PlantGroup extends DataUnit {

    @JsonIgnore
    public static final String PLANTS_TYPES_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantGroup.PLANTS_TYPES_PROPERTY";

    private Set<PlantType> plantsTypes = new HashSet<>();

    public List<PlantType> getPlantsTypes() {
        return new ArrayList<>(plantsTypes);
    }

    public void setPlantsTypes(List<PlantType> plantsTypes) {
        this.plantsTypes = new HashSet<>(plantsTypes);
        fireChange(PLANTS_TYPES_PROPERTY);
    }

    /**
     * Add a plant type to this group.
     * @param type - The plant type.
     * @return true if the plant type is added, otherwise return false.
     */
    public boolean addPlantsType(PlantType type) {
        boolean added = plantsTypes.add(type);
        if(added) {
            type.setGroup(this);
        }
        fireChange(PLANTS_TYPES_PROPERTY, false, added);
        return added;
    }

    public boolean removePlantsType(PlantType type) {
        boolean success = plantsTypes.remove(type);
        fireChange(PLANTS_TYPES_PROPERTY, false, success);
        return success;
    }
}
