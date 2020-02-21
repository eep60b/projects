package com.etlsolutions.gwise.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 * The ValueWrapper class wraps an value. If the value has been changed, the
 * third party will be notified via property change listeners.
 *
 * @author zc
 * @param <T> - The value type.
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

    public void removePropertyChangeListeners() {

        PropertyChangeListener[] listeners = support.getPropertyChangeListeners();
        for (int i = listeners.length - 1; i >= 0; i--) {
            support.removePropertyChangeListener(listeners[i]);
        }
    }

    public void addNonDuplicatedDataUnitPropertyChangeAdapter(String propertyName, PropertyChangeListener adapter) {

        for (PropertyChangeListener listener : support.getPropertyChangeListeners(propertyName)) {

            if (Objects.equals(adapter, listener)) {
                return;
            }
            support.addPropertyChangeListener(propertyName, adapter);
        }
    }
    

    public void addNonDuplicatedDataUnitPropertyChangeAdapter(PropertyChangeAdapter adapter) {

        for (PropertyChangeListener listener : support.getPropertyChangeListeners()) {

            if (Objects.equals(adapter, listener)) {
                return;
            }
            support.addPropertyChangeListener(adapter);
        }
    }
}
