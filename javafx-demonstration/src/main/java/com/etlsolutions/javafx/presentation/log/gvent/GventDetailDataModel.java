package com.etlsolutions.javafx.presentation.log.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.data.log.gvent.GventDetailValueWrapper;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class GventDetailDataModel<T extends GventDetailValueWrapper> {

    protected final T detail;

    public GventDetailDataModel(T detail) {
        this.detail = detail;
    }

    public abstract String getFxmlPath();
    
    public GventType getType() {
        return detail.getType();
    }

    public T getDetail() {
        return detail;
    }
}
