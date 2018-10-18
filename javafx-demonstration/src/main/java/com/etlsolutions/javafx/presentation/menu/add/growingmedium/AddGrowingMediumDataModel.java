package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.GrowingMedium;
import com.etlsolutions.javafx.data.GrowingMediumFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.system.ProjectManager;

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
        sandPercentage = 32;
        siltPercentage = 32;
        clayPercentage = 16;
        organicPercentage = 20;
        stonePercentage = 0;
        waterStoragePercentage = 20;
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
    public void save() {
        
        growingMedium = GrowingMediumFactory.getInstance().createGrowingMedium(title, information, imageLinks, 0, title, 
                new double[]{sandPercentage, siltPercentage, clayPercentage, organicPercentage, stonePercentage, waterStoragePercentage, ph}, true);
        ProjectManager.getInstance().getProject().getGrowingMediums().add(growingMedium);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGrowingMediumFXML.fxml";
    }
    
    public GrowingMedium getGrowingMedium() {
        return growingMedium;
    }
}
