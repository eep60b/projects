package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class LiquidFertiliserDetail extends FertiliserDetail {

    private final ValueWrapper<Boolean> diluted;
    private final ValueWrapper<String> dilutedWaterAmount;
    private final ValueWrapper<String> dilutedWaterUom;

    public LiquidFertiliserDetail(boolean diluted, double dilutedWaterAmount, String dilutedWaterUom, String manufacturer, double suggestedUsageAmount, String usageUom, double ph, double aluminium, double boron, double calcium, double chlorine, double cobalt, double copper, double iron, double magnesium, double manganese, double molybdenum, double nitrogen, double nickel, double phosphorus, double potassium, double selenium, double sodium, double sulphur, double vanadium, double zinc) {
        super(manufacturer, suggestedUsageAmount, usageUom, ph, aluminium, boron, calcium, chlorine, cobalt, copper, iron, magnesium, manganese, molybdenum, nitrogen, nickel, phosphorus, potassium, selenium, sodium, sulphur, vanadium, zinc);
        this.diluted = new ValueWrapper<>(diluted);
        this.dilutedWaterAmount = new ValueWrapper<>(String.valueOf(dilutedWaterAmount));
        this.dilutedWaterUom = new ValueWrapper<>(dilutedWaterUom);
    }

    public ValueWrapper<Boolean> getDiluted() {
        return diluted;
    }

    public ValueWrapper<String> getDilutedWaterAmount() {
        return dilutedWaterAmount;
    }

    public ValueWrapper<String> getDilutedWaterUom() {
        return dilutedWaterUom;
    }
    
    @Override
    public FertiliserType getType() {
        
        return FertiliserType.LIQUID;
    }
    
}
