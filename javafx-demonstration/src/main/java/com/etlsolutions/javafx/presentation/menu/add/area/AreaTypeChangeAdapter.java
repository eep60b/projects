/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author Zhipeng
 */
public class AreaTypeChangeAdapter implements ChangeListener<SingleSelectionModel<AreaType>> {

    private final AddAreaDialogDataModel model;

    public AreaTypeChangeAdapter(AddAreaDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<AreaType>> observable, SingleSelectionModel<AreaType> oldValue, SingleSelectionModel<AreaType> newValue) {
        model.setSelectedAreaType(newValue.getSelectedItem());
    }
    
}
