package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.Fertiliser;

/**
 *
 * @author zc
 */
public class GwiseSolidFertiliserBean extends Fertiliser {

    private double density;
    private String densityUom;

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
