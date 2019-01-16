package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class FertilisationTask extends Task
{
  public static final String PROPERTY = "com.etlsolutions.javafx.data.log.task.FertilisationTask.PROPERTY";
  
  private int fertiliserId;
  private double amount;
  private String uom;

    public FertilisationTask() {
    }

    public FertilisationTask(DataUnitValueWrapper valueWrapper, FertilisationTaskValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
        fertiliserId = detailValueWrapper.getFertiliserValueWrapper().getValue().getId();
        amount = detailValueWrapper.getAmount();
        uom = detailValueWrapper.getUomValueWrapper().getValue();
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
