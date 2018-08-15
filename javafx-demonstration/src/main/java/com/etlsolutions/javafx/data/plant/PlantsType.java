package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import static com.etlsolutions.javafx.system.SettingConstants.DEFAULT_DATAUNIT_TITLE_BUNDLE_KEY;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 * The PlantsType class represents a plant type which loosely corresponding to the plant species. As the plant species is not restrictively used by shops and gardeners, Examples: Strawberry,
 * Squash, Bean, Pea etc.
 *
 * @author zc
 */
public class PlantsType extends DataUnit {

  @JsonIgnore  
  public static final String PLANTS_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsType.PLANTS_PROPERTY";
  
  private List<Plants> plantsList;

 
          
  public List<Plants> getPlantses() {
    return new ArrayList<>(plantsList);
  }
  
  public boolean addPlants(Plants plants) {
    boolean added = plantsList.add(plants);
    fireChange(PLANTS_PROPERTY, false, added);
    return added;
  }
  
  public boolean removePlants(Plants plants) {
    boolean removed = plantsList.add(plants);
    fireChange(PLANTS_PROPERTY, false, removed);
    return removed;
  }  

  @Override
  public DataUnit createInitialisedInstance() {
        plantsList = new ArrayList<>();
    setTitle(BUNDLE.getString(DEFAULT_DATAUNIT_TITLE_BUNDLE_KEY));
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
