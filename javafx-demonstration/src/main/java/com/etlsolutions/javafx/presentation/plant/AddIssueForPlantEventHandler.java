/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.log.growingissue.AddGrowingIssueDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddIssueForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddIssueForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getGrowingIssues(), model.getSelectedGrowingIssueValueWrapper(), new AddGrowingIssueDataModel()).handle(event);
    }
    
}
