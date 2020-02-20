package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class GrowingMediumSpecialValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<String> sandPercentageWrapper;
    private final ValueWrapper<String>  siltPercentageWrapper;
    private final ValueWrapper<String>  clayPercentageWrapper;
    private final ValueWrapper<String>  organicPercentageWrapper;
    private final ValueWrapper<String>  stonePercentageWrapper;
    private final ValueWrapper<String>  waterStoragePercentageWrapper;
    private final ValueWrapper<String>  phWrapper;
    private final ValueWrapper<Boolean> fertilisedWrapper;

    public GrowingMediumSpecialValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLink, String logoPath, double sandPercentage, double siltPercentage, double clayPercentage, double organicPercentage, double stonePercentage, double waterStoragePercentage, double ph, boolean fertilised) {
        
        super(title, information, imageLinks, selectedImgLink, logoPath);       
        sandPercentageWrapper = getWrapper(sandPercentage);
        siltPercentageWrapper = getWrapper(siltPercentage);
        clayPercentageWrapper = getWrapper(clayPercentage);
        organicPercentageWrapper = getWrapper(organicPercentage);
        stonePercentageWrapper = getWrapper(stonePercentage);
        waterStoragePercentageWrapper = getWrapper(waterStoragePercentage);
        phWrapper = getWrapper(ph);
        fertilisedWrapper = new ValueWrapper<>(fertilised);
    }

    public GrowingMediumSpecialValueWrapper(GrowingMedium growingMedium) {
        super(growingMedium);
        sandPercentageWrapper = getWrapper(growingMedium.getSandPercentage());
        siltPercentageWrapper = getWrapper(growingMedium.getSiltPercentage());
        clayPercentageWrapper = getWrapper(growingMedium.getClayPercentage());
        organicPercentageWrapper = getWrapper(growingMedium.getOrganicPercentage());
        stonePercentageWrapper = getWrapper(growingMedium.getStonePercentage());
        waterStoragePercentageWrapper = getWrapper(growingMedium.getWaterStoragePercentage());
        phWrapper = getWrapper(growingMedium.getPh());
        fertilisedWrapper = new ValueWrapper<>(growingMedium.isFertilised());        
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
        return getValue(sandPercentageWrapper);
    }

    public double getSiltPercentage() {
        return getValue(siltPercentageWrapper);
    }

    public double getClayPercentage() {
        return getValue(clayPercentageWrapper);
    }

    public double getOrganicPercentage() {
        return getValue(organicPercentageWrapper);
    }

    public double getStonePercentage() {
        return getValue(stonePercentageWrapper);
    }

    public double getWaterStoragePercentage() {
        return getValue(waterStoragePercentageWrapper);
    }

    public double getPh() {
        return getValue(phWrapper);
    }
  
    public boolean isFertilised() {
        return fertilisedWrapper.getValue();
    }
}
