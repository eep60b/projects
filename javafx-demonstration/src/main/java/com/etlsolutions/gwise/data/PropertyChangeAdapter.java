package com.etlsolutions.gwise.data;

import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 *
 * @author ZhipengChang
 * @param <T>
 */
public abstract class PropertyChangeAdapter<T> implements PropertyChangeListener {

    protected final T source;

    /**
     * Construct an object for this class.
     * @param source - The source of this apter.
     */
    public PropertyChangeAdapter(T source) {
        this.source = source;
    }

    @Override
    public final int hashCode() {
        
        return 13 * 7 + Objects.hashCode(source);
    }

    //The equals and hashcode are implemented in such a way to avoid dupliced listeners to be added in the property support. 
    @Override
    public final boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final PropertyChangeAdapter<?> other = (PropertyChangeAdapter<?>) obj;
        
        //Only the same source are considered to be equal.
        return this.source == other.source;
    }
}
