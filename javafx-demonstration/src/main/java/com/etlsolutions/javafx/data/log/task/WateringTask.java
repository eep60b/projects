package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class WateringTask extends Task {

    private WateringType wateringType;
    private WaterType waterType;
    private boolean fertilised;
    private int fertiliserId;
    private double amount;
    private String amountUom;
    private double flux;
    private String fluxUom;
    private int duration;

    public WateringTask() {
    }

    public WateringTask(DataUnitValueWrapper valueWrapper, WateringTaskValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
        wateringType = detailValueWrapper.getWateringTypeValueWrapper().getValue();
        waterType = detailValueWrapper.getWaterTypeValueWrapper().getValue();
        fertilised = detailValueWrapper.getFertilisedValueWrapper().getValue();
        fertiliserId = detailValueWrapper.getFertiliserValueWrapper().getValue().getId();
        amount = detailValueWrapper.getAmount();
        amountUom = detailValueWrapper.getAmountUomValueWrapper().getValue();
        flux = detailValueWrapper.getFlux();
        fluxUom = detailValueWrapper.getFluxUomValueWrapper().getValue();
        duration = detailValueWrapper.getDurationValueWrapper().getValue();
    }

    public WateringType getWateringType() {
        return wateringType;
    }

    public void setWateringType(WateringType wateringType) {
        this.wateringType = wateringType;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    public boolean isFertilised() {
        return fertilised;
    }

    public void setFertilised(boolean fertilised) {
        this.fertilised = fertilised;
    }

    public int getFertiliserId() {
        return fertiliserId;
    }

    public void setFertiliserId(int fertiliserId) {
        this.fertiliserId = fertiliserId;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAmountUom() {
        return amountUom;
    }

    public void setAmountUom(String amountUom) {
        this.amountUom = amountUom;
    }

    public double getFlux() {
        return flux;
    }

    public void setFlux(double flux) {
        this.flux = flux;
    }

    public String getFluxUom() {
        return fluxUom;
    }

    public void setFluxUom(String fluxUom) {
        this.fluxUom = fluxUom;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    @Override
    public TaskType getType() {
        return TaskType.WATERING;
    }
}
