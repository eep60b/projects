package com.etlsolutions.javafx.data.other;

/**
 *
 * @author zc
 */
public class SolidGrowingFertiliser extends GrowingFertiliser
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
