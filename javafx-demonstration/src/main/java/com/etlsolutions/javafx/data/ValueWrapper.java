package com.etlsolutions.javafx.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author zc
 * @param <T>
 */
public class ValueWrapper<T> {

    public static final String VALUE_CHANGE = ValueWrapper.class.getName() + "VALUE_CHANGE";
    
    private T value;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    public ValueWrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        T oldValue = this.value;
        this.value = value;
        support.firePropertyChange(VALUE_CHANGE, oldValue, this.value);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    public boolean hasListeners(String propertyName) {
        return support.hasListeners(propertyName);
    }
}
