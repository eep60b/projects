package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGrowingMediumBean extends GwiseDataUnitBean {

    private double sandPercentage;
    private double siltPercentage;
    private double clayPercentage;
    private double organicPercentage;
    private double stonePercentage;
    private double waterStoragePercentage;
    private double ph;
    private boolean fertilised;

    public GwiseGrowingMediumBean() {
    }

    
    public GwiseGrowingMediumBean(GwiseGrowingMedium g) {
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

    public boolean isFertilised() {
        return fertilised;
    }

    public void setFertilised(boolean fertilised) {
        this.fertilised = fertilised;
    }
}
