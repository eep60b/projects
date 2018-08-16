package com.etlsolutions.javafx.data.plant;

import static com.etlsolutions.javafx.data.DataUnit.BUNDLE;
import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantsFactory {

  public static PlantsGroupRoot createPlantsGroupRoot() {
    PlantsGroupRoot r = new PlantsGroupRoot();
    r.setId(DataUnitIdRegistry.createNewId());
    String[] defaultTitles = BUNDLE.getStringArray("com.etlsolutions.javafx.data.plant.PlantsGroupRoot.defaultPlantsGroups.Titles");
    List<PlantsGroup> groups = new ArrayList<>();
    for(String title : defaultTitles) {
      PlantsGroup group = createPlantsGroup(title);
      groups.add(group);
    }
    r.setPlantsGroups(groups);
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
    p.setVariety(createPlantVariety());
    p.setQuantity(createPlantsQuantity());
    p.setGrowingDetails(createGrowingDetail());
    return p;
  }
  
  public static PlantVariety createPlantVariety() {
    PlantVariety v = new PlantVariety();
    return v;
  }
  
  public static PlantsQuantity createPlantsQuantity() {
    PlantsQuantity p = new PlantsQuantity();
    return p;
  }
  
  public static GrowingDetail createGrowingDetail() {
    GrowingDetail d = new GrowingDetail();
    return d;
  }
}
