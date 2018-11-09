package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class SolidFertiliserDetailValueWrapper implements FertiliserDetailValueWrapper {

    private final ValueWrapper<String> density;
    private final ValueWrapper<String> densityUom;

    public SolidFertiliserDetailValueWrapper(double density, String densityUom) {
        this.density = new ValueWrapper<>(String.valueOf(density));
        this.densityUom = new ValueWrapper<>(densityUom);
    }

    public ValueWrapper<String> getDensity() {
        return density;
    }

    public ValueWrapper<String> getDensityUom() {
        return densityUom;
    }

    @Override
    public FertiliserType getType() {

        return FertiliserType.SOLID;
    }

}
