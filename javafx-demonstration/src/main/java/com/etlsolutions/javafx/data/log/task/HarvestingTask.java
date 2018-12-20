package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class HarvestingTask extends Task
{
  private String quality;
  private double quatantity;
  private String uom;

    public HarvestingTask() {
    }

    public HarvestingTask(DataUnitValueWrapper valueWrapper, HarvestingTaskDetailValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
        quality = detailValueWrapper.getQuality().getValue();
        quatantity = detailValueWrapper.getQuatantity();
        uom = detailValueWrapper.getUomValueWrapper().getValue();
    }
    
  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
  }

  public double getQuatantity() {
    return quatantity;
  }

  public void setQuatantity(double quatantity) {
    this.quatantity = quatantity;
  }

  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }
  
      @Override
    public TaskType getType() {
        return TaskType.HARVESTING;
    }
}
