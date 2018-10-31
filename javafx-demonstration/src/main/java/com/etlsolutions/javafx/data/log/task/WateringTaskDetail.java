package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class WateringTaskDetail implements TaskDetail {
    
  private double duration = 0.5;
  private double amount;
  private String uom;

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
