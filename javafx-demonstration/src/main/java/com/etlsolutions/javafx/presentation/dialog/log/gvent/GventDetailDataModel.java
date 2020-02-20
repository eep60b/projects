package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.data.log.gvent.GventDetailValueWrapper;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class GventDetailDataModel<T extends GventDetailValueWrapper> implements FXMLActionDataModel{

    protected final T detail;

    public GventDetailDataModel(T detail) {
        this.detail = detail;
    }
    
    public GventType getType() {
        return detail.getType();
    }

    public T getDetail() {
        return detail;
    }
}
