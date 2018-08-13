package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;

/**
 * Each object of the Plants class represents a set of plants with an identical variety which are planted in the same time and under the same condition. They should be treated in the same way all the
 * time. If anything is going to be set differently, a new object should be used.
 *
 * @author zc
 */
public class Plants extends DataUnit {

  public static final String PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.PROPERTY";
  
  private PlantVariety variety;
  private PlantsQuantity quantity;
  private GrowingDetail growingDetails;

  public PlantVariety getVariety() {
    return variety;
  }

  public void setVariety(PlantVariety variety) {
    this.variety = variety;
  }

  public PlantsQuantity getQuantity() {
    return quantity;
  }

  public void setQuantity(PlantsQuantity quantity) {
    this.quantity = quantity;
  }

  public GrowingDetail getGrowingDetails() {
    return growingDetails;
  }

  public void setGrowingDetails(GrowingDetail growingDetails) {
    this.growingDetails = growingDetails;
  }  
}
