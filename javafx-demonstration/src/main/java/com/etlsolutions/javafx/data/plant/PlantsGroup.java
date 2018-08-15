package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 * The PlantsGroup class represents a child of root item. Because the root item
 * does BIT show in GUI, this class actually acts as the multiple roots from the
 * user point of view. A good example of groups is trees, annual plants,
 * biennial plants and perennial plants etc.
 *
 * @author zc
 */
public class PlantsGroup extends DataUnit {

    @JsonIgnore
    public static final String PLANTS_TYPES_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsGroup.PLANTS_TYPES_PROPERTY";

    private List<PlantsType> plantsTypes = new ArrayList<>();

    public List<PlantsType> getPlantsTypes() {
        return new ArrayList<>(plantsTypes);
    }

    public void setPlantsTypes(List<PlantsType> plantsTypes) {
        this.plantsTypes = new ArrayList<>(plantsTypes);
        fireChange(PLANTS_TYPES_PROPERTY);
    }

    public boolean addPlantsType(PlantsType type) {
        boolean success = plantsTypes.add(type);
        fireChange(PLANTS_TYPES_PROPERTY, false, success);
        return success;
    }

    public boolean removePlantsType(PlantsType type) {
        boolean success = plantsTypes.remove(type);
        fireChange(PLANTS_TYPES_PROPERTY, false, success);
        return success;
    }

    @Override
    public DataUnit createInitialisedInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
