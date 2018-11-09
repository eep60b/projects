package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.TypedItem;

/**
 *
 * @author zc
 * @param <T>
 * @param <I>
 */
public abstract class PartDataModel <T, I extends TypedItem<T>> {

    private final I itemPartValueWrapper;

    public PartDataModel(I itemPartValueWrapper) {
        this.itemPartValueWrapper = itemPartValueWrapper;
    }
    
    public abstract String getFxmlPath();
    
    
    public T getType() {
        return itemPartValueWrapper.getType();
    }
}
