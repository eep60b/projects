package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.Log;

/**
 *
 * @author zc
 */
public class HarvestingTask extends Log
{
  private String quality;
  private double quatantity;
  private String uom;

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
  
}
