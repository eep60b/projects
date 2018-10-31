package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public class CustomDetail implements GventDetail {

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }
    
}
