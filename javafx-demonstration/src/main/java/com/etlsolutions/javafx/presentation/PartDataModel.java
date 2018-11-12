package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.TypedItem;

/**
 *
 * @author zc
 * @param <T> - The type class.
 * @param <I> - The item class.
 */
public abstract class PartDataModel <T, I extends TypedItem<T>> {

    protected final I itemPartValueWrapper;

    public PartDataModel(I itemPartValueWrapper) {
        this.itemPartValueWrapper = itemPartValueWrapper;
    }
    
    public abstract String getFxmlPath();

    public I getItemPartValueWrapper() {
        return itemPartValueWrapper;
    }
}
