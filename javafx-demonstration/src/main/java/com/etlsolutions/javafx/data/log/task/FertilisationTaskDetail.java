package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class FertilisationTaskDetail implements TaskDetail {

    private int fertiliserId;
    private double amount;
    private String uom;

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

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    @Override
    public TaskType getType() {
        return TaskType.FERTILZATION;
    }
}