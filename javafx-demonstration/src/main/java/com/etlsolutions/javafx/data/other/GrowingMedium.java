package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitCommonValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private double stonePercentage;
    private double waterStoragePercentage;
    private double ph;
    private boolean fertilised;

    public GrowingMedium() {
    }

    public GrowingMedium(DataUnitCommonValueWrapper commonValueWrapper, GrowingMediumSpecialValueWrapper specialValueWrapper) {
        super(commonValueWrapper);
        sandPercentage = Double.parseDouble(specialValueWrapper.getSandPercentageWrapper().getValue());
        siltPercentage = Double.parseDouble(specialValueWrapper.getSiltPercentageWrapper().getValue());
        clayPercentage = Double.parseDouble(specialValueWrapper.getClayPercentageWrapper().getValue());
        organicPercentage = Double.parseDouble(specialValueWrapper.getOrganicPercentageWrapper().getValue());
        stonePercentage = Double.parseDouble(specialValueWrapper.getStonePercentageWrapper().getValue());
        waterStoragePercentage = Double.parseDouble(specialValueWrapper.getWaterStoragePercentageWrapper().getValue());
        ph = Double.parseDouble(specialValueWrapper.getPhWrapper().getValue());
        fertilised = specialValueWrapper.getFertilisedWrapper().getValue();
    }

    GrowingMedium(String title, String information, double[] compositions, boolean fertilised) {
        super(title, information);

        int i = 0;
        sandPercentage = compositions[i];
        siltPercentage = compositions[i++];
        clayPercentage = compositions[i++];
        organicPercentage = compositions[i++];
        stonePercentage = compositions[i++];
        waterStoragePercentage = compositions[i++];
        ph = compositions[i++];
        this.fertilised = fertilised;
    }

    GrowingMedium(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);

        int i = 0;
        sandPercentage = compositions[i];
        siltPercentage = compositions[i++];
        clayPercentage = compositions[i++];
        organicPercentage = compositions[i++];
        stonePercentage = compositions[i++];
        waterStoragePercentage = compositions[i++];
        ph = compositions[i++];
        this.fertilised = fertilised;
    }

    GrowingMedium(int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        int i = 0;
        sandPercentage = compositions[i];
        siltPercentage = compositions[i++];
        clayPercentage = compositions[i++];
        organicPercentage = compositions[i++];
        stonePercentage = compositions[i++];
        waterStoragePercentage = compositions[i++];
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

    public double getStonePercentage() {
        return stonePercentage;
    }

    public void setStonePercentage(double stonePercentage) {
        double oldValue = this.stonePercentage;
        this.stonePercentage = stonePercentage;
        fireChange(STONE_PERCENTAGE_PROPERTY, oldValue, this.stonePercentage);
    }

    public double getWaterStoragePercentage() {
        return waterStoragePercentage;
    }

    public void setWaterStoragePercentage(double waterStoragePercentage) {
        double oldValue = this.waterStoragePercentage;
        this.waterStoragePercentage = waterStoragePercentage;
        fireChange(WATER_PERCENTAGE_PROPERTY, oldValue, this.waterStoragePercentage);
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
    
    public void setValues(DataUnitCommonValueWrapper commonValueWrapper, GrowingMediumSpecialValueWrapper specialValueWrapper) {
        
        setCommonValues(commonValueWrapper);
        
        setSandPercentage(specialValueWrapper.getSandPercentage());
        setSiltPercentage(specialValueWrapper.getSiltPercentage());
        setClayPercentage(specialValueWrapper.getClayPercentage());
        setOrganicPercentage(specialValueWrapper.getOrganicPercentage());
        setStonePercentage(specialValueWrapper.getStonePercentage());
        setWaterStoragePercentage(specialValueWrapper.getWaterStoragePercentage());
        setPh(specialValueWrapper.getPh());
        setFertilised(specialValueWrapper.isFertilised());
    }
}
