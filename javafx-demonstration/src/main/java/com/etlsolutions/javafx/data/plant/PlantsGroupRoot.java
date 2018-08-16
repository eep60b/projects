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

  public List<PlantsGroup> getPlantsGroups() {
    return new ArrayList<>(plantsGroups);
  }

  public void setPlantsGroups(List<PlantsGroup> plantsGroups) {
    this.plantsGroups = new ArrayList<>(plantsGroups);
    fireChange(PLANTS_GROUPS_PROPERTY);
  }

  public boolean addPlantsGroup(PlantsGroup group) {
    boolean added = plantsGroups.add(group);
    fireChange(PLANTS_GROUPS_PROPERTY, false, added);
    return added;
  }

  public boolean removePlantsGroup(PlantsGroup group) {
    boolean removed = plantsGroups.remove(group);
    fireChange(PLANTS_GROUPS_PROPERTY, false, removed);
    return removed;
  }
}
