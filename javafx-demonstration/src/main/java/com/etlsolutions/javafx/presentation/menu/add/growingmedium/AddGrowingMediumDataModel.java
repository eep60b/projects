package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;

/**
 *
 * @author zc
 */
public class AddGrowingMediumDataModel extends DataUnitFXMLDataModel {

    private double sandPercentage;
    private double siltPercentage;
    private double clayPercentage;
    private double organicPercentage;
    private double stonePercentage;
    private double waterStoragePercentage;
    private double ph;
    
    private GrowingMedium growingMedium;


    public AddGrowingMediumDataModel() {
        sandPercentage = 32.0;
        siltPercentage = 32.0;
        clayPercentage = 16.0;
        organicPercentage = 20.0;
        stonePercentage = 0.0;
        waterStoragePercentage = 20.0;
        ph = 6.8;
                
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
    protected void validate() {
        valid = title != null && ! title.isEmpty();
        errorMessage = valid ? "" : "Please enter the title.";
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGrowingMediumFXML.fxml";
    }
    
    public GrowingMedium getGrowingMedium() {
        return growingMedium;
    }
}
