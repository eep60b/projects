package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public class CustomGventDetail implements GventDetail {

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }

}
