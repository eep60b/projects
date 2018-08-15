package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author zc
 */
public class PlantsFactory {

  public static PlantsGroupRoot createPlantsGroupRoot() {
    PlantsGroupRoot r = new PlantsGroupRoot();
    r.setId(DataUnitIdRegistry.createNewId());
    PlantsGroup treePlantsGroup = createPlantsGroup("Trees");
    PlantsGroup annualPlantsGroup = createPlantsGroup("Annual Plants");
    PlantsGroup biennialPlantsGroup = createPlantsGroup("Biennial Plants");
    PlantsGroup perennialPlantsGroup = createPlantsGroup("Perennial Plants"); 
    r.setPlantsGroups(Arrays.asList(treePlantsGroup, annualPlantsGroup, biennialPlantsGroup, perennialPlantsGroup));
    return r;
  }
  
  public static PlantsGroup createPlantsGroup() {
    return createPlantsGroup("untitled");
  } 
  
  public static PlantsGroup createPlantsGroup(String title) {
    PlantsGroup g = new PlantsGroup();
    g.setId(DataUnitIdRegistry.createNewId());
    g.setTitle(title);
    g.setInformation("");
    g.setLogoPath("");
    g.setPlantsTypes(new ArrayList<PlantsType>());
    return g;
  }  
  
  public static PlantsType creatPlantsType() {
    PlantsType t = new PlantsType();
    t.setId(DataUnitIdRegistry.createNewId());
    t.setTitle("untitled");
    t.setInformation("");
    t.setLogoPath("");
    t.setPlantsList(new ArrayList<Plants>());
    return t;
  } 
  
  public static Plants creatPlants() {
    Plants p = new Plants();
    p.setId(DataUnitIdRegistry.createNewId());
    p.setTitle("untitled");
    p.setInformation("");
    p.setLogoPath("");
    return p;
  }   
}
