/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author Zhipeng
 */
public class AddSubAreaEventHandler implements EventHandler<ActionEvent> {

    private final AbstractAreaDataModel model;
    private final ListView<SubArea> subAreaListView;

    public AddSubAreaEventHandler(AbstractAreaDataModel model, ListView<SubArea> subAreaListView) {
        this.model = model;
        this.subAreaListView = subAreaListView;
    }

    @Override
    public void handle(ActionEvent event) {
        AddSubAreaDataModel addSubAreaDataModel = new AddSubAreaDataModel(model.getSelectedAreaType().getTypes());
        new FXMLActionEventHandler<>(addSubAreaDataModel).handle(event);
        SubArea subArea = addSubAreaDataModel.getSubArea();
        model.getSubAreas().add(subArea);
        model.setSelectedSubArea(subArea);
        subAreaListView.setItems(model.getSubAreas());
        subAreaListView.getSelectionModel().select(subArea);
    }
    
}
