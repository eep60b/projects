package com.etlsolutions.gwise.data;

import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.util.Callback;

/**
 *
 * @author zc
 * @param <E>
 */
public class ObservableListWrapperA<E> extends ObservableListWrapper<E> {

    private final Map<String, ListChangeListener<? super E>> classListenerMap = new HashMap<>();
    
    private final Set<ListChangeAdapter> dataUnitlisteners = new HashSet<>(); 
    
    /**
     * This constructor is necessary for JSON to de-serialise object which
     * contains list.
     */
    public ObservableListWrapperA() {
        super(new ArrayList<E>());
    }


    public ObservableListWrapperA(E item) {
        super(new ArrayList<E>());
        add(item);
    }    
        
    public ObservableListWrapperA(E... items) {
        super(new ArrayList<E>());
        addAll(items);
    }
    
    public ObservableListWrapperA(List<? extends E> list) {
        super(new ArrayList<E>());
        addAll(list);
    }

    public ObservableListWrapperA(List<E> list, Callback<E, Observable[]> extractor) {
        super(new ArrayList<E>(), extractor);
        addAll(list);
    }
    
    public void removeAndGetNext(ValueWrapper<E> wrapper) {
        
        E e = wrapper.getValue();
        int index = indexOf(e);
        remove(e);
        index = index == size() ? index - 1 : index;
        
        wrapper.setValue(index == -1 ? null : get(index));
    }
    
    public void replaceListenerForClass(String className, ListChangeListener<? super E> listener) {
        
        synchronized(classListenerMap){
            
            ListChangeListener<? super E> l = classListenerMap.get(className);
            if(l != null) {
                removeListener(l);
            }
            addListener(listener);
            classListenerMap.put(className, listener);
        }
    }
    
    public void addNonDuplicatedAdapter(ListChangeAdapter<? super E> adapter) {
        
        if(dataUnitlisteners.contains(adapter)) {
            return;
        }
        
        dataUnitlisteners.add(adapter);        
        addListener(adapter);
    }
}
