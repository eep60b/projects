package com.etlsolutions.javafx.data;

import java.util.Objects;

/**
 *
 * @author zc
 */
public abstract class DataUnitChangeAdapter implements DataUnitChangeListener {

    private final DataUnit unit;

    public DataUnitChangeAdapter(DataUnit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.unit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final DataUnitChangeAdapter other = (DataUnitChangeAdapter) obj;
        
        return Objects.equals(this.unit, other.unit);
    }
}
