package com.etlsolutions.javafx.presentation;

import java.beans.PropertyChangeSupport;

/**
 *
 * @author zc
 */
public class DataUnitPropertyChangeSupport extends PropertyChangeSupport {
    
    public DataUnitPropertyChangeSupport(Object sourceBean) {
        super(sourceBean);
    }
    
    public void firePropertyChange(String property) {
        super.firePropertyChange(property, true, false);
    }
}
