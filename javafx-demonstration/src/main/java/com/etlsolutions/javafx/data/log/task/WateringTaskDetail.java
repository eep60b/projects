package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;

/**
 *
 * @author zc
 */
public class WateringTaskDetail implements TaskDetail {
    
    private final ValueWrapper<WateringType> wateringType;
    private final ValueWrapper<WaterType> waterType;
    private final ValueWrapper<Boolean> fertilised;
    private final ValueWrapper<LiquidFertiliser> fertiliser;
    private final ValueWrapper<String> amount;
    private final ValueWrapper<String> amountUom;
    private final ValueWrapper<String> flux;
    private final ValueWrapper<String> fluxUom;
    private final ValueWrapper<Integer> duration;

    public WateringTaskDetail(WateringType wateringType, WaterType waterType, boolean fertilised, LiquidFertiliser fertiliser, double amount, String amountUom, double flux, String fluxUom, int duration) {
        this.wateringType = new ValueWrapper<>(wateringType);
        this.waterType = new ValueWrapper<>(waterType);
        this.fertilised = new ValueWrapper<>(fertilised);
        this.fertiliser = new ValueWrapper<>(fertiliser);
        this.amount = new ValueWrapper<>(String.valueOf(amount));
        this.amountUom = new ValueWrapper<>(amountUom);
        this.flux = new ValueWrapper<>(String.valueOf(flux));
        this.fluxUom = new ValueWrapper<>(fluxUom);
        this.duration = new ValueWrapper<>(duration);        
    }

    public ValueWrapper<WateringType> getWateringType() {
        return wateringType;
    }

    public ValueWrapper<WaterType> getWaterType() {
        return waterType;
    }

    public ValueWrapper<Boolean> getFertilised() {
        return fertilised;
    }

    public ValueWrapper<LiquidFertiliser> getFertiliser() {
        return fertiliser;
    }

    public ValueWrapper<String> getAmount() {
        return amount;
    }

    public ValueWrapper<String> getAmountUom() {
        return amountUom;
    }

    public ValueWrapper<String> getFlux() {
        return flux;
    }

    public ValueWrapper<String> getFluxUom() {
        return fluxUom;
    }

    public ValueWrapper<Integer> getDuration() {
        return duration;
    }

    @Override
    public TaskType getType() {
        return TaskType.WATERING;
    }
}
