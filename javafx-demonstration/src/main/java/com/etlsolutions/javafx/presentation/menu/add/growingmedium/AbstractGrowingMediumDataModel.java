package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.GrowingMedium;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingMediumDataModel extends DataUnitFXMLDataModel {

    protected double sandPercentage;
    protected double siltPercentage;
    protected double clayPercentage;
    protected double organicPercentage;
    protected double stonePercentage;
    protected double waterStoragePercentage;
    protected double ph;
    
    protected GrowingMedium growingMedium;

    public AbstractGrowingMediumDataModel(double sandPercentage, double siltPercentage, double clayPercentage, double organicPercentage, double stonePercentage, double waterStoragePercentage, double ph) {
        this.sandPercentage = sandPercentage;
        this.siltPercentage = siltPercentage;
        this.clayPercentage = clayPercentage;
        this.organicPercentage = organicPercentage;
        this.stonePercentage = stonePercentage;
        this.waterStoragePercentage = waterStoragePercentage;
        this.ph = ph;
    }
    
    public double getSandPercentage() {
        return sandPercentage;
    }

    public void setSandPercentage(double sandPercentage) {
        this.sandPercentage = sandPercentage;
    }

    public double getSiltPercentage() {
        return siltPercentage;
    }

    public void setSiltPercentage(double siltPercentage) {
        this.siltPercentage = siltPercentage;
    }

    public double getClayPercentage() {
        return clayPercentage;
    }

    public void setClayPercentage(double clayPercentage) {
        this.clayPercentage = clayPercentage;
    }

    public double getOrganicPercentage() {
        return organicPercentage;
    }

    public void setOrganicPercentage(double organicPercentage) {
        this.organicPercentage = organicPercentage;
    }

    public double getStonePercentage() {
        return stonePercentage;
    }

    public void setStonePercentage(double stonePercentage) {
        this.stonePercentage = stonePercentage;
    }

    public double getWaterStoragePercentage() {
        return waterStoragePercentage;
    }

    public void setWaterStoragePercentage(double waterStoragePercentage) {
        this.waterStoragePercentage = waterStoragePercentage;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/GrowingMediumFXML.fxml";
    }
    
    public GrowingMedium getGrowingMedium() {
        return growingMedium;
    }
}
