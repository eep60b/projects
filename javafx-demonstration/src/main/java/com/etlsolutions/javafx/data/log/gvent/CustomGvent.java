package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public class CustomGvent extends Gvent {

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }

}
