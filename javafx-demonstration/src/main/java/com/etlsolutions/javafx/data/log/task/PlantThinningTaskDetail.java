package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PlantThinningTaskDetail implements TaskDetail {

    private final ValueWrapper<Integer> totalPlants;
    private final ValueWrapper<Integer> thinningRatio;

    public PlantThinningTaskDetail(int totalPlants, int thinningRatio) {
        this.totalPlants = new ValueWrapper<>(totalPlants);
        this.thinningRatio = new ValueWrapper<>(thinningRatio);
    }

    public ValueWrapper<Integer> getTotalPlants() {
        return totalPlants;
    }
    
    public ValueWrapper<Integer> getThinningRatio() {
        return thinningRatio;
    }

    @Override
    public TaskType getType() {
        return TaskType.PLANT_THINNING;
    }
}
