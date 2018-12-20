package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class WateringTaskDetailValueWrapper extends TaskDetailValueWrapper {
    
    private final ValueWrapper<WateringType> wateringTypeValueWrapper;
    private final ValueWrapper<WaterType> waterTypeValueWrapper;
    private final ValueWrapper<Boolean> fertilisedValueWrapper;
    private final ValueWrapper<LiquidFertiliser> fertiliserValueWrapper;
    private final ValueWrapper<String> amountValueWrapper;
    private final ValueWrapper<String> amountUomValueWrapper;
    private final ValueWrapper<String> fluxValueWrapper;
    private final ValueWrapper<String> fluxUomValueWrapper;
    private final ValueWrapper<Integer> durationValueWrapper;

    public WateringTaskDetailValueWrapper() {
        wateringTypeValueWrapper = new ValueWrapper<>(WateringType.USE_WATER_CAN);
        waterTypeValueWrapper = new ValueWrapper<>(WaterType.RAIN_WATER);
        fertilisedValueWrapper = new ValueWrapper<>(false);
        ProjectContents c = ProjectManager.getInstance().getContents();
        fertiliserValueWrapper = new ValueWrapper<>(c.getLiquidFertilisers().get(0));
        amountValueWrapper = new ValueWrapper<>("1.0");
        amountUomValueWrapper = new ValueWrapper<>(c.getWateringAmountUoms().get(0));
        fluxValueWrapper = new ValueWrapper<>("1.0");
        fluxUomValueWrapper = new ValueWrapper<>(c.getWateringFluxUoms().get(0));
        durationValueWrapper = new ValueWrapper<>(3); 
    }

    public WateringTaskDetailValueWrapper(WateringTask task) {
        super(task);
        wateringTypeValueWrapper = new ValueWrapper<>(task.getWateringType());
        waterTypeValueWrapper = new ValueWrapper<>(task.getWaterType());
        fertilisedValueWrapper = new ValueWrapper<>(task.isFertilised());
        fertiliserValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<LiquidFertiliser>getItem(task.getFertiliserId()));
        amountValueWrapper = new ValueWrapper<>(String.valueOf(task.getAmount()));
        amountUomValueWrapper = new ValueWrapper<>(task.getAmountUom());
        fluxValueWrapper = new ValueWrapper<>("0");
        fluxUomValueWrapper = new ValueWrapper<>(task.getFluxUom());
        durationValueWrapper = new ValueWrapper<>(task.getDuration()); 
    }

    public ValueWrapper<WateringType> getWateringTypeValueWrapper() {
        return wateringTypeValueWrapper;
    }

    public ValueWrapper<WaterType> getWaterTypeValueWrapper() {
        return waterTypeValueWrapper;
    }

    public ValueWrapper<Boolean> getFertilisedValueWrapper() {
        return fertilisedValueWrapper;
    }

    public ValueWrapper<LiquidFertiliser> getFertiliserValueWrapper() {
        return fertiliserValueWrapper;
    }

    public ValueWrapper<String> getAmountValueWrapper() {
        return amountValueWrapper;
    }

    public ValueWrapper<String> getAmountUomValueWrapper() {
        return amountUomValueWrapper;
    }

    public ValueWrapper<String> getFluxValueWrapper() {
        return fluxValueWrapper;
    }

    public ValueWrapper<String> getFluxUomValueWrapper() {
        return fluxUomValueWrapper;
    }

    public ValueWrapper<Integer> getDurationValueWrapper() {
        return durationValueWrapper;
    }

    @Override
    public TaskType getType() {
        return TaskType.WATERING;
    }

    public double getAmount() {
        return Double.parseDouble(amountValueWrapper.getValue());
    }

    public double getFlux() {
        return Double.parseDouble(fluxValueWrapper.getValue());
    }
}
