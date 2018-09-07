package com.etlsolutions.javafx.presentation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class TitleChangeAdapter implements ChangeListener<String> {

    private final TitleDataModel model;

    public TitleChangeAdapter(TitleDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setTitle(newValue);
    }

}
