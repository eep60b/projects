package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class WateringTask extends Task {

    private WateringType wateringType;
    private WaterType waterType;
    private boolean fertilised;
    private int fertiliserId;
    private double duration = 0.5;
    private double amount;
    private String uom;

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
    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    @Override
    public TaskType getType() {
        return TaskType.WATERING;
    }
}
