/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.fertiliser.EditFertiliserDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class EDitFertiliserEventHandler implements EventHandler<ActionEvent> {

    private final FertilisationTaskDetailDataModel model;

    public EDitFertiliserEventHandler(FertilisationTaskDetailDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditFertiliserDataModel(model.getSelectedFertiliser().getValue()));
    }
    
}
