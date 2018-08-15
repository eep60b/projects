package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Each object of the Plants class represents a set of plants with an identical variety which are planted in the same time and under the same condition. They should be treated in the same way all the
 * time. If anything is going to be set differently, a new object should be used.
 *
 * @author zc
 */
public class Plants extends DataUnit {

  @JsonIgnore  
  public static final String VARIEETY_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.VARIEETY_PROPERTY";
  @JsonIgnore  
  public static final String QUANTITY_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.QUANTITY_PROPERTY";
  @JsonIgnore  
  public static final String GROWING_DETAILS_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.GROWING_DETAILS_PROPERTY";
  
  private PlantVariety variety;
  private PlantsQuantity quantity;
  private GrowingDetail growingDetails;
  
  public PlantVariety getVariety() {
    return variety;
  }

  public void setVariety(PlantVariety variety) {
    PlantVariety oldValue = this.variety;
    this.variety = variety;
    fireChange(VARIEETY_PROPERTY, oldValue, this.variety);
  }

  public PlantsQuantity getQuantity() {
    return quantity;
  }

  public void setQuantity(PlantsQuantity quantity) {
    PlantsQuantity oldValue = quantity;
    this.quantity = quantity;
    fireChange(QUANTITY_PROPERTY, oldValue, oldValue);
  }

  public GrowingDetail getGrowingDetails() {
    return growingDetails;
  }

  public void setGrowingDetails(GrowingDetail growingDetails) {
    GrowingDetail oldValue = this.growingDetails;
    this.growingDetails = growingDetails;
    fireChange(TITLE_PROPERTY, oldValue, this.growingDetails);
  }  

  @Override
  public DataUnit createInitialisedInstance() {
        variety = new PlantVariety();
    quantity = new PlantsQuantity();
    growingDetails = new GrowingDetail();
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
