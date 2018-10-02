package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class GrowingMedium extends DataUnit {

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

    GrowingMedium(String title, String information, double[] compositions, boolean fertilised) {
        super(title, information);
        
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
    
    GrowingMedium(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        
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

    GrowingMedium(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
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
