package com.etlsolutions.javafx.presentation;

import java.util.List;

/**
 *
 * @author zc
 */
public class PlantsItem implements Item {

  private final int id;
  private String name;
  private PlantVariety variety;
  private PlantsQuantity quantity;
  private GrowingDetails growingDetails;
  private List<LogItem> logs;
  private String selectedImgLink;
  private List<String> imgLinks;

  public PlantsItem(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PlantsItem other = (PlantsItem) obj;

    return this.id == other.id;
  }
}
