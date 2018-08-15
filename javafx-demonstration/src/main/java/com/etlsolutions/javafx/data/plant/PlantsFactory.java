package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitIdRegistry;

/**
 *
 * @author zc
 */
public class PlantsFactory {

  public static PlantsGroupRoot createPlantsGroupRoot() {
    PlantsGroupRoot r = new PlantsGroupRoot();
    r.setId(DataUnitIdRegistry.createNewId());
    r.setTitle("");
    
    return r;
  }
  
  public static PlantsGroup createPlantsGroup() {
    PlantsGroup g = new PlantsGroup();
    
    return g;
  }
}
