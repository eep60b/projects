package com.etlsolutions.javafx.presentation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class InformationChangeAdapter  implements ChangeListener<String> {

    private final InformationDataModel model;

    public InformationChangeAdapter(InformationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setInformation(newValue);
    }

}