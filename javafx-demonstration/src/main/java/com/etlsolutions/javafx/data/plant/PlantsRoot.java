package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;

/**
 *
 * @author zc
 */
public class PlantsRoot extends DataUnit {
  
  private final PlantGroup annualPlantGroup = new PlantGroup();
  private final PlantGroup beannualPlantGroup = new PlantGroup();
  private final PlantGroup perennialPlantGroup = new PlantGroup();
  private final PlantGroup treePlantGroup = new PlantGroup();
}
