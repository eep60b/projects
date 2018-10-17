package com.etlsolutions.javafx.data;

import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.Observable;
import javafx.util.Callback;

/**
 *
 * @author zc
 * @param <E>
 */
public class ObservableListWrapperA<E> extends ObservableListWrapper<E> {

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
    
    public ObservableListWrapperA(E[] items) {
        super(new ArrayList<E>());
        addAll(items);
    }

    public ObservableListWrapperA(List<E> list) {
        super(new ArrayList<E>());
        addAll(list);
    }

    public ObservableListWrapperA(List<E> list, Callback<E, Observable[]> extractor) {
        super(new ArrayList<E>(), extractor);
        addAll(list);
    }
}
