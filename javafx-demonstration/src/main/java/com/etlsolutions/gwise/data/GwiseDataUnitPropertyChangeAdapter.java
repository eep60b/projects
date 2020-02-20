package com.etlsolutions.gwise.data;

import java.beans.PropertyChangeListener;

/**
 *
 * @author ZhipengChang
 */
public abstract class GwiseDataUnitPropertyChangeAdapter implements PropertyChangeListener {

    protected final GwiseDataUnit unit;

    public GwiseDataUnitPropertyChangeAdapter(GwiseDataUnit unit) {
        this.unit = unit;
    }

    public GwiseDataUnit getUnit() {
        return unit;
    }    
}
