package com.etlsolutions.javafx.data.other;

/**
 *
 * @author zc
 */
public class SolidFertiliser extends Fertiliser
{
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
}
