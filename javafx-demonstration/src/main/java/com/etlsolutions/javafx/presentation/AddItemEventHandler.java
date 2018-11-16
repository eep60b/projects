package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 * @param <D>
 */
public class AddItemEventHandler<D extends DataUnit> implements EventHandler<ActionEvent> {

    private final ObservableListWrapperA<D> list;
    private final ValueWrapper<D> item;
    private final DataUnitFXMLDataModel<D> model;

    public AddItemEventHandler(ObservableListWrapperA<D> list, ValueWrapper<D> item, DataUnitFXMLDataModel<D> model) {
        this.list = list;
        this.item = item;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        new FXMLActionEventHandler<>(model).handle(event);
        D t = model.get();
        if (t != null) {
            list.add(t);
            item.setValue(t);
        }

    }

}
