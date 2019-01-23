package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.growingissue.EditGrowingIssueDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditIssueForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public EditIssueForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditGrowingIssueDataModel(model.getSelectedGrowingIssueValueWrapper().getValue())).handle(event);
    }
    
}
