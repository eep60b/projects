package com.etlsolutions.javafx.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class DataUnitChangeSupport {
    
    private final Logger logger = Logger.getLogger(getClass());
    private final Map<String, Set<DataUnitChangeListener>> map = new HashMap<>();

    public synchronized boolean addListener(String property, DataUnitChangeListener listener) {

        if (listener == null) {
            logger.warn("Trying to add an invalid listener.\n" + Arrays.toString(Thread.currentThread().getStackTrace()));            
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
    
    public synchronized void removeListeners() {

        map.clear();
    }   
    
    public synchronized void replaceListener(String property, DataUnitChangeListener listener) {

        if (listener == null) {
            logger.warn("Trying to add an invalid listener.\n" + Arrays.toString(Thread.currentThread().getStackTrace()));            
            return;
        }

        Set<DataUnitChangeListener> listeners = map.get(property);
        if (listeners == null) {
            listeners = new HashSet<>();
            map.put(property, listeners);
        }
        
        Iterator<DataUnitChangeListener> iterator = listeners.iterator();
        while(iterator.hasNext()) {
            DataUnitChangeListener l = iterator.next();
            
            if(listener.getClass() == l.getClass()) {
                listeners.remove(l);
                listeners.add(listener);
                return;
            }
            
        }
        
        listeners.add(listener);
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
