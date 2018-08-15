package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitPart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zc
 */
public class GrowingMedium extends DataUnitPart {

  @JsonIgnore
  public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.TITLE_PROPERTY";
  @JsonIgnore
  public static final String SAND_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.SAND_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String SILT_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.SILT_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String CLAY_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.CLAY_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String ORGANIC_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.ORGANIC_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String STONE_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.STONE_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String WATER_PERCENTAGE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.WATER_PERCENTAGE_PROPERTY";
  @JsonIgnore
  public static final String PH_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.PH_PROPERTY";
  @JsonIgnore
  public static final String FERTILISED_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingMedium.FERTILISED_PROPERTY";

  
  @JsonIgnore
  private static final Map<String, double[]> DEFAULT_VALUES = new HashMap<>();
  @JsonIgnore
  private static final List<String> DEFAULT_TITLES = new ArrayList<>();

  static {
    DEFAULT_VALUES.put("Loam", new double[]{28, 28, 14, 20, 0, 10, 7.0});
    DEFAULT_VALUES.put("Sandy soil", new double[]{50, 35, 5, 5, 0, 5, 6.5});
    DEFAULT_VALUES.put("Silt soil", new double[]{25, 50, 5, 10, 0, 10, 6.8});
    DEFAULT_VALUES.put("Peat soi", new double[]{10, 10, 5, 50, 0, 25, 6.3});
    DEFAULT_VALUES.put("Clay soil (light)", new double[]{15, 15, 45, 15, 0, 10, 7.0});
    DEFAULT_VALUES.put("Clay soil (heavy)", new double[]{10, 10, 60, 10, 0, 10, 7.0});
    DEFAULT_VALUES.put("Chalky soil", new double[]{28, 28, 14, 10, 20, 10, 7.0});
    DEFAULT_VALUES.put("Multipurpose compost", new double[]{0, 0, 0, 80, 0, 20, 7.0});
    DEFAULT_VALUES.put("Ericaceous compost", new double[]{0, 0, 0, 80, 0, 20, 5.2});
    DEFAULT_VALUES.put("Stony soil", new double[]{30, 10, 0, 5, 50, 5, 7.0});
    DEFAULT_VALUES.put("Plant liquid culture", new double[]{0, 0, 0, 0, 0, 100, 15});
    DEFAULT_TITLES.addAll(DEFAULT_VALUES.keySet());
    Collections.sort(DEFAULT_TITLES);
  }

  private String title;
  private double sandPercentage;
  private double siltPercentage;
  private double clayPercentage;
  private double organicPercentage;
  private double stonepaencentage;
  private double waterPercentage;
  private double ph;
  private boolean fertilised;

  public GrowingMedium() {
  }

  public GrowingMedium(String title, double[] compositions, boolean fertilised) {
    this.title = title;
    int i = 0;
    sandPercentage = compositions[i];
    siltPercentage = compositions[i++];
    clayPercentage = compositions[i++];
    organicPercentage = compositions[i++];
    stonepaencentage = compositions[i++];
    waterPercentage = compositions[i++];
    ph = compositions[i++];
    this.fertilised = fertilised;
  }

  @Override
  public GrowingMedium createInitialisedInstance() {
    
    GrowingMedium m = new GrowingMedium();
    return m;
  }

  public static List<String> getDefaultKeys() {
    return new ArrayList<>(DEFAULT_TITLES);
  }

  public static GrowingMedium getInstance(String title) {
    double[] values = DEFAULT_VALUES.get(title);
    return values == null ? new GrowingMedium(title, DEFAULT_VALUES.get(DEFAULT_TITLES.get(0)), true) : new GrowingMedium(title, values, true);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    String oldValue = this.title;
    this.title = title;
    fireChange(TITLE_PROPERTY, oldValue, this.title);
  }

  public double getSandPercentage() {
    return sandPercentage;
  }

  public void setSandPercentage(double sandPercentage) {
    double oldValue = this.sandPercentage;
    this.sandPercentage = sandPercentage;
    fireChange(SAND_PERCENTAGE_PROPERTY, oldValue, this.sandPercentage);
  }

  public double getSiltPercentage() {
    return siltPercentage;
  }

  public void setSiltPercentage(double siltPercentage) {
    double oldValue = this.siltPercentage;
    this.siltPercentage = siltPercentage;
    fireChange(SILT_PERCENTAGE_PROPERTY, oldValue, this.siltPercentage);
  }

  public double getClayPercentage() {
    return clayPercentage;
  }

  public void setClayPercentage(double clayPercentage) {
    double oldValue = this.clayPercentage;
    this.clayPercentage = clayPercentage;
    fireChange(CLAY_PERCENTAGE_PROPERTY, oldValue, this.clayPercentage);
  }

  public double getOrganicPercentage() {
    return organicPercentage;
  }

  public void setOrganicPercentage(double organicPercentage) {
    double oldValue = this.organicPercentage;
    this.organicPercentage = organicPercentage;
    fireChange(ORGANIC_PERCENTAGE_PROPERTY, oldValue, this.organicPercentage);
  }

  public double getStonepaencentage() {
    return stonepaencentage;
  }

  public void setStonepaencentage(double stonepaencentage) {
    double oldValue = this.stonepaencentage;
    this.stonepaencentage = stonepaencentage;
    fireChange(STONE_PERCENTAGE_PROPERTY, oldValue, this.stonepaencentage);
  }

  public double getWaterPercentage() {
    return waterPercentage;
  }

  public void setWaterPercentage(double waterPercentage) {
    double oldValue = this.waterPercentage;
    this.waterPercentage = waterPercentage;
    fireChange(WATER_PERCENTAGE_PROPERTY, oldValue, this.waterPercentage);
  }

  public double getPh() {
    return ph;
  }

  public void setPh(double ph) {
    double oldValue = this.ph;
    this.ph = ph;
    fireChange(PH_PROPERTY, oldValue, this.ph);
  }

  public boolean isFertilised() {
    return fertilised;
  }

  public void setFertilised(boolean fertilised) {
    boolean oldValue = this.fertilised;
    this.fertilised = fertilised;
    fireChange(FERTILISED_PROPERTY, oldValue, this.fertilised);
  }
}
