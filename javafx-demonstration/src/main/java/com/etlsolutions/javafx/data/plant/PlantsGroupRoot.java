package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantsGroupRoot extends DataUnit {

    @JsonIgnore
    public static final String PLANTS_GROUPS_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsGroupRoot.PLANTS_GROUPS_PROPERTY";
    
    private List<PlantsGroup> plantsGroups;

    @Override
    public DataUnit createInitialisedInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PlantsGroup> getPlantsGroups() {
        return new ArrayList<>(plantsGroups);
    }

    public void setPlantsGroups(List<PlantsGroup> plantsGroups) {
        this.plantsGroups = new ArrayList<>(plantsGroups);
    }
}
