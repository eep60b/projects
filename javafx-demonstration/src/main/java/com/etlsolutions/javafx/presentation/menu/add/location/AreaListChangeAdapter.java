/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class AreaListChangeAdapter implements ListChangeListener<Area> {

    private final ComboBox<Area> areaComboBox;
    private final TypeSelectionDataModel model;

    public AreaListChangeAdapter(ComboBox<Area> areaComboBox, TypeSelectionDataModel model) {        
        this.areaComboBox = areaComboBox;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends Area> c) {
         areaComboBox.getSelectionModel().select(model.getSelectedArea());
    }  
}
