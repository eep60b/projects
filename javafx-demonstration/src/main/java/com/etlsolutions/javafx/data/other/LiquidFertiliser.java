package com.etlsolutions.javafx.data.other;

/**
 *
 * @author zc
 */
public class LiquidFertiliser extends Fertiliser
{
    private boolean diluted;
    private double dilutedWaterAmount;
    private String dilutedWaterUom;

    public boolean isDiluted() {
        return diluted;
    }

    public void setDiluted(boolean diluted) {
        this.diluted = diluted;
    }

    public double getDilutedWaterAmount() {
        return dilutedWaterAmount;
    }

    public void setDilutedWaterAmount(double dilutedWaterAmount) {
        this.dilutedWaterAmount = dilutedWaterAmount;
    }

    public String getDilutedWaterUom() {
        return dilutedWaterUom;
    }

    public void setDilutedWaterUom(String dilutedWaterUom) {
        this.dilutedWaterUom = dilutedWaterUom;
    }
    
    @Override
    public FertiliserType getType() {
        return FertiliserType.LIQUID;
    }
}
