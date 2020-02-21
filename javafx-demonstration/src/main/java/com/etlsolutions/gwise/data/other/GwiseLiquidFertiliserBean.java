package com.etlsolutions.gwise.data.other;

/**
 *
 * @author zc
 */
public class GwiseLiquidFertiliserBean extends GwiseFertiliserBean
{
    private boolean diluted;
    private double dilutionRatio;
    private String dilutionRatioUom;

    
    
    public boolean isDiluted() {
        return diluted;
    }

    public void setDiluted(boolean diluted) {
        this.diluted = diluted;
    }

    public double getDilutionRatio() {
        return dilutionRatio;
    }

    public void setDilutionRatio(double dilutionRatio) {
        this.dilutionRatio = dilutionRatio;
    }

    public String getDilutionRatioUom() {
        return dilutionRatioUom;
    }

    public void setDilutionRatioUom(String dilutionRatioUom) {
        this.dilutionRatioUom = dilutionRatioUom;
    }
    
    @Override
    public FertiliserType getType() {
        return FertiliserType.LIQUID;
    }
}
