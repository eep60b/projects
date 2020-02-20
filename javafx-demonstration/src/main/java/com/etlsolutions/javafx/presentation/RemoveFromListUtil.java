package com.etlsolutions.javafx.presentation;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public final class RemoveFromListUtil {

    public static final RemoveFromListUtil INSTANCE = new RemoveFromListUtil();

    private RemoveFromListUtil() {
    }
    
    public static final RemoveFromListUtil getInstance() {
        return INSTANCE;
    }
    
    
    public <E> void remove(ObservableListWrapperA<E> list, ValueWrapper<E> wrapper) {
        
        int i = list.indexOf(wrapper.getValue());        
        list.remove(i);        
        wrapper.setValue(list.isEmpty() ? null : list.size() == i ? list.get(i - 1) : list.get(i));
    }
}
