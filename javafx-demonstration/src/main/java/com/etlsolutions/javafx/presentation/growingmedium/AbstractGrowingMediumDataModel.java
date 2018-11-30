package com.etlsolutions.javafx.presentation.growingmedium;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.other.GrowingMediumSpecialValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingMediumDataModel extends DataUnitFXMLDataModel<GrowingMedium> {

    protected GrowingMediumSpecialValueWrapper specialValueWrapper;

    public AbstractGrowingMediumDataModel(GrowingMedium dataUnit) {
        super(dataUnit);
        specialValueWrapper = new GrowingMediumSpecialValueWrapper(dataUnit);
    }
    
    public AbstractGrowingMediumDataModel(double sandPercentage, double siltPercentage, double clayPercentage, double organicPercentage, double stonePercentage, double waterStoragePercentage, double ph, boolean fertilised) {
        specialValueWrapper = new GrowingMediumSpecialValueWrapper(sandPercentage, siltPercentage, clayPercentage, organicPercentage, stonePercentage, waterStoragePercentage, ph, fertilised);
    }

    public ValueWrapper<String> getSandPercentage() {
        return specialValueWrapper.getSandPercentageWrapper();
    }

    public ValueWrapper<String> getSiltPercentage() {
        return specialValueWrapper.getSiltPercentageWrapper();
    }

    public ValueWrapper<String> getClayPercentage() {
        return specialValueWrapper.getClayPercentageWrapper();
    }

    public ValueWrapper<String> getOrganicPercentage() {
        return specialValueWrapper.getOrganicPercentageWrapper();
    }

    public ValueWrapper<String> getStonePercentage() {
        return specialValueWrapper.getStonePercentageWrapper();
    }

    public ValueWrapper<String> getWaterStoragePercentage() {
        return specialValueWrapper.getWaterStoragePercentageWrapper();
    }

    public ValueWrapper<String> getPh() {
        return specialValueWrapper.getPhWrapper();
    }
    
    public ValueWrapper<Boolean> getFertilised() {
        return specialValueWrapper.getFertilisedWrapper();
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/GrowingMediumFXML.fxml";
    }
}
