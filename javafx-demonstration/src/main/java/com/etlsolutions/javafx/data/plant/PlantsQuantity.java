package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitChangeListener;
import com.etlsolutions.javafx.data.DataUnitChangeSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class PlantsQuantity {

  public static enum Type {
    SINGLE, MULTIPLE, ESTIMATION, NO_COUNTING
  }

  @JsonIgnore
  public static final String PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsQuantity.PROPERTY";

  @JsonIgnore
  private final DataUnitChangeSupport support = new DataUnitChangeSupport();

  private int quantity;
  private Type type;

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    int oldValue = this.quantity;
    this.quantity = quantity;
    support.fireChange(PROPERTY, oldValue, this.quantity);

  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    Type oldValue = this.type;
    this.type = type;
    support.fireChange(PROPERTY, oldValue, this.type);
  }

  public synchronized boolean addListener(String property, DataUnitChangeListener listener) {
    return support.addListener(property, listener);
  }
}
