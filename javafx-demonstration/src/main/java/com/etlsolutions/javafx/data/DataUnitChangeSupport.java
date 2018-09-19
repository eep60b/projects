package com.etlsolutions.javafx.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author zc
 */
public final class DataUnitChangeSupport {

    private final Map<String, Set<DataUnitChangeListener>> map = new HashMap<>();

    public synchronized boolean addListener(String property, DataUnitChangeListener listener) {

        if (listener == null) {
            return false;
        }

        Set<DataUnitChangeListener> listeners = map.get(property);
        if (listeners == null) {
            listeners = new HashSet<>();
            map.put(property, listeners);
        }
        return listeners.add(listener);
    }

    public synchronized boolean removeListener(String property, DataUnitChangeListener listener) {

        if (listener == null) {
            return false;
        }

        Set<DataUnitChangeListener> listeners = map.get(property);
        
        if (listeners != null) {
            listeners.remove(listener);
        }
        
        return false;
    }    
    
    public synchronized void fireChange(String property) {

        Set<DataUnitChangeListener> listeners = map.get(property);

        if (listeners == null) {
            return;
        }

        for (DataUnitChangeListener listener : listeners) {
            listener.change();
        }
    }

    public synchronized void fireChange(String property, Object oldVaue, Object newValue) {

        if (Objects.equals(oldVaue, newValue)) {
            return;
        }

        fireChange(property);
    }

    public synchronized void fireChange() {

        for (String property : map.keySet()) {
            fireChange(property);
        }
    }
}
