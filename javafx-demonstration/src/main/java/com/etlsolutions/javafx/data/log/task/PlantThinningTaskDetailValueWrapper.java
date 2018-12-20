package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PlantThinningTaskDetailValueWrapper extends TaskDetailValueWrapper {

    private final ValueWrapper<Integer> totalPlants;
    private final ValueWrapper<Integer> thinningRatio;

    public PlantThinningTaskDetailValueWrapper() {
        this.totalPlants = new ValueWrapper<>(1);
        this.thinningRatio = new ValueWrapper<>(1);
    }

    public PlantThinningTaskDetailValueWrapper(PlantThinningTask task) {
        super(task);
        this.totalPlants = new ValueWrapper<>(task.getTotalPlants());
        this.thinningRatio = new ValueWrapper<>(task.getThinningRatio());
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
