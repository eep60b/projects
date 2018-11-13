package com.etlsolutions.javafx.data.other;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class LiquidFertiliserSpecialValueWrapper implements FertiliserSpecialValueWrapper {

    private final ValueWrapper<Boolean> diluted;
    private final ValueWrapper<String> dilutionRatio;
    private final ValueWrapper<String> dilutionRatioUom;

    public LiquidFertiliserSpecialValueWrapper(boolean diluted, double dilutionRatio, String dilutionRatioUom) {
        this.diluted = new ValueWrapper<>(diluted);
        this.dilutionRatio = new ValueWrapper<>(String.valueOf(dilutionRatio));
        this.dilutionRatioUom = new ValueWrapper<>(dilutionRatioUom);
    }

    public ValueWrapper<Boolean> getDiluted() {
        return diluted;
    }

    public ValueWrapper<String> getDilutionRatio() {
        return dilutionRatio;
    }

    public ValueWrapper<String> getDilutionRatioUom() {
        return dilutionRatioUom;
    }
    
    @Override
    public FertiliserType getType() {
        
        return FertiliserType.LIQUID;
    }
}
