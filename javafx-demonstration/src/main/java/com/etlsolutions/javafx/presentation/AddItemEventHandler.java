package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 * @param <T>
 */
public class AddItemEventHandler<T> implements EventHandler<ActionEvent> {

    private final ObservableListWrapperA<T> list;
    private final ValueWrapper<T> item;
    private final DataUnitFXMLDataModel<T> model;

    public AddItemEventHandler(ObservableListWrapperA<T> list, ValueWrapper<T> item, DataUnitFXMLDataModel<T> model) {
        this.list = list;
        this.item = item;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        new FXMLActionEventHandler<>(model).handle(event);
        T t = model.get();
        if (t != null) {
            list.add(t);
            item.setValue(t);
        }

    }

}
