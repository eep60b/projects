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
public class ObservableListWrapperA<E> extends ObservableListWrapper<E>{

    public ObservableListWrapperA() {
        super(new ArrayList<E>());
    }

    public ObservableListWrapperA(List<E> list) {
        super(list);
    }

    public ObservableListWrapperA(List<E> list, Callback<E, Observable[]> extractor) {
        super(list, extractor);
    }
}
