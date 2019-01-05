package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class CustomGvent extends Gvent {

    public CustomGvent() {
    }
    
    public CustomGvent(DataUnitValueWrapper valueWrapper, CustomGventDetailValueWrapper customGventDetailValueWrapper) {
        super(valueWrapper, customGventDetailValueWrapper);
    }

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }

}
