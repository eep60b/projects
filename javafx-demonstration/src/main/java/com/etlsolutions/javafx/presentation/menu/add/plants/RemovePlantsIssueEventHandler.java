/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantsIssueEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public RemovePlantsIssueEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedGrowingIssue();
    }
}
