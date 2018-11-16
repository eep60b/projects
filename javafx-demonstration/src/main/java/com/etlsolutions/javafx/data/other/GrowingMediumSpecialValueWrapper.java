package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class GrowingMediumSpecialValueWrapper {

    private final ValueWrapper<String> sandPercentageWrapper;
    private final ValueWrapper<String>  siltPercentageWrapper;
    private final ValueWrapper<String>  clayPercentageWrapper;
    private final ValueWrapper<String>  organicPercentageWrapper;
    private final ValueWrapper<String>  stonePercentageWrapper;
    private final ValueWrapper<String>  waterStoragePercentageWrapper;
    private final ValueWrapper<String>  phWrapper;
    private final ValueWrapper<Boolean> fertilisedWrapper;

    public GrowingMediumSpecialValueWrapper(double sandPercentage, double siltPercentage, double clayPercentage, double organicPercentage, double stonePercentage, double waterStoragePercentage, double ph, boolean fertilised) {
        this.sandPercentageWrapper = convert(sandPercentage);
        this.siltPercentageWrapper = convert(siltPercentage);
        this.clayPercentageWrapper = convert(clayPercentage);
        this.organicPercentageWrapper = convert(organicPercentage);
        this.stonePercentageWrapper = convert(stonePercentage);
        this.waterStoragePercentageWrapper = convert(waterStoragePercentage);
        this.phWrapper = convert(ph);
        this.fertilisedWrapper = new ValueWrapper<>(fertilised);
    }

    public GrowingMediumSpecialValueWrapper(GrowingMedium dataUnit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private ValueWrapper<String> convert(double value) {
        return new ValueWrapper<>(String.valueOf(value));
    }
    
    public ValueWrapper<String> getSandPercentageWrapper() {
        return sandPercentageWrapper;
    }

    public ValueWrapper<String> getSiltPercentageWrapper() {
        return siltPercentageWrapper;
    }

    public ValueWrapper<String> getClayPercentageWrapper() {
        return clayPercentageWrapper;
    }

    public ValueWrapper<String> getOrganicPercentageWrapper() {
        return organicPercentageWrapper;
    }

    public ValueWrapper<String> getStonePercentageWrapper() {
        return stonePercentageWrapper;
    }

    public ValueWrapper<String> getWaterStoragePercentageWrapper() {
        return waterStoragePercentageWrapper;
    }

    public ValueWrapper<String> getPhWrapper() {
        return phWrapper;
    }
  
    public ValueWrapper<Boolean> getFertilisedWrapper() {
        return fertilisedWrapper;
    }    
    
    public double getSandPercentage() {
        return convert(sandPercentageWrapper);
    }

    public double getSiltPercentage() {
        return convert(siltPercentageWrapper);
    }

    public double getClayPercentage() {
        return convert(clayPercentageWrapper);
    }

    public double getOrganicPercentage() {
        return convert(organicPercentageWrapper);
    }

    public double getStonePercentage() {
        return convert(stonePercentageWrapper);
    }

    public double getWaterStoragePercentage() {
        return convert(waterStoragePercentageWrapper);
    }

    public double getPh() {
        return convert(phWrapper);
    }
  
    public boolean isFertilised() {
        return fertilisedWrapper.getValue();
    } 
    
    private double convert(ValueWrapper<String> wrapper) {
        return Double.parseDouble(wrapper.getValue());
    }
}
