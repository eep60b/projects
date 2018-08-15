package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantVariety extends DataUnitPart {
  
  private String title;
  private List<String> aliases;
  private String latinName = "Not specified";

  @Override
  public PlantVariety createInitialisedInstance() {
    PlantVariety v = new PlantVariety();
    latinName = "Not specified";
    return v;
  }
}
