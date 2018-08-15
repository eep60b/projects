package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantsRoot extends DataUnit {

  @JsonIgnore
  public static final String PLANTS_GROUPS_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsRoot.PLANTS_GROUPS_PROPERTY";

  private List<PlantsGroup> plantsGroups;

  public List<PlantsGroup> getPlantsGroups() {
    return plantsGroups;
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

  @Override
  public DataUnit createInitialisedInstance() {
    PlantsRoot r = new PlantsRoot();
    String[] defaultTitles = BUNDLE.getStringArray("com.etlsolutions.javafx.data.plant.PlantRoot.defaultPlantsGroups.Titles");
    plantsGroups = new ArrayList<>();
    for (String title : defaultTitles) {
      PlantsGroup group = new PlantsGroup();
      group.setTitle(title);
      plantsGroups.add(group);
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    return r;
  }
}
