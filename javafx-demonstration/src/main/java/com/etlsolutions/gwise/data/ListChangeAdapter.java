package com.etlsolutions.gwise.data;

import java.util.List;
import javafx.collections.ListChangeListener;

/**
 *
 * @author ZhipengChang
 * @param <E>
 */
public abstract class ListChangeAdapter<E> implements ListChangeListener<E> {

    private final List<E> unit;

    public ListChangeAdapter(List<E> list) {
        this.unit = list;
    }

    @Override
    public final int hashCode() {
        return 7 * 29;
    }

    //This method is overridden in such a way to guarantee that no duplicated adapters are added to the same list. 
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
        final ListChangeAdapter<?> other = (ListChangeAdapter<?>) obj;
        
        return this.unit == other.unit;
    }
}
