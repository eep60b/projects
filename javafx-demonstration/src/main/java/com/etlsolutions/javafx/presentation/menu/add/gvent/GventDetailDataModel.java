package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventDetail;
import com.etlsolutions.javafx.data.log.gvent.GventType;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class GventDetailDataModel<T extends GventDetail> {

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
