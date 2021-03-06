package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class PlantThinningTask extends Task {
  
  private int totalPlants;
  private int raminingPlants;
  private int thinningRatio;

    public PlantThinningTask() {
    }

    public PlantThinningTask(DataUnitValueWrapper valueWrapper, PlantThinningTaskValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
        totalPlants = detailValueWrapper.getTotalPlantsValueWrapper().getValue();
        thinningRatio = detailValueWrapper.getThinningRatioValueWrapper().getValue();
    }

    public int getTotalPlants() {
        return totalPlants;
    }

    public void setTotalPlants(int totalPlants) {
        this.totalPlants = totalPlants;
    }

    public int getRaminingPlants() {
        return raminingPlants;
    }

    public void setRaminingPlants(int raminingPlants) {
        this.raminingPlants = raminingPlants;
    }
    
    public int getThinningRatio() {
        return thinningRatio;
    }

    public void setThinningRatio(int thinningRatio) {
        this.thinningRatio = thinningRatio;
    }
  
     @Override
    public TaskType getType() {
        return TaskType.PLANT_THINNING;
    } 
}
