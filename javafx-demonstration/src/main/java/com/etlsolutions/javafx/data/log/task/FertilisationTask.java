package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.Log;

/**
 *
 * @author zc
 */
public class FertilisationTask extends Log
{
  public static final String PROPERTY = "com.etlsolutions.javafx.data.log.task.FertilisationTask.PROPERTY";
  
  private GrowingFertiliser fertiliser;
  private double amount;
  private String uom;

  public GrowingFertiliser getFertiliser() {
    return fertiliser;
  }

  public void setFertiliser(GrowingFertiliser fertiliser) {
    this.fertiliser = fertiliser;
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
}
