package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class SolidFertiliserDetail extends FertiliserDetail {

    private final ValueWrapper<String> density;
    private final ValueWrapper<String> densityUom;

    public SolidFertiliserDetail(double density, String densityUom, String manufacturer, double suggestedUsageAmount, String usageUom, double ph, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc) {
        super(manufacturer, suggestedUsageAmount, usageUom, ph, aluminium, boron, calcium, chlorine, cobalt, copper, iron, magnesium, manganese, molybdenum, nitrogen, nickel, phosphorus, potassium, selenium, sodium, sulphur, vanadium, zinc);
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
