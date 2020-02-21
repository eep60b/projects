package com.etlsolutions.gwise.data.other;

/**
 *
 * @author zc
 */
public class GwiseSolidFertiliserBean extends GwiseFertiliserBean {

    private double density;
    private String densityUom;

    public GwiseSolidFertiliserBean() {
    }

    public GwiseSolidFertiliserBean(GwiseSolidFertiliser unit) {
        super(unit);
    }

    
    
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getDensityUom() {
        return densityUom;
    }

    public void setDensityUom(String densityUom) {
        this.densityUom = densityUom;
    }

    @Override
    public FertiliserType getType() {
        return FertiliserType.LIQUID;
    }
}
