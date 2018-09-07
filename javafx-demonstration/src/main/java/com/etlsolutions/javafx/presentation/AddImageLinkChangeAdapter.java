/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class AddImageLinkChangeAdapter implements ChangeListener<SelectionModel<ImageLink>>{

    private final ImageLinkDataModel model;

    public AddImageLinkChangeAdapter(ImageLinkDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<ImageLink>> observable, SelectionModel<ImageLink> oldValue, SelectionModel<ImageLink> newValue) {
        model.add(newValue.getSelectedItem());
    }
}
