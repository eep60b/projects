package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.ActionEventHandler;

/**
 *
 * @author zc
 */
public class AddPlantVarietyEventHandler extends ActionEventHandler<VarietyAddable> {

    public AddPlantVarietyEventHandler(VarietyAddable model) {
        super(model);
    }

    @Override
    public String getFxmlFilePath() {
        return "/fxml/menu/add/AddPlantVarietyDialogFXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "Add Plant Variety";
    }

    @Override
    public String getErrorMessage() {
        return "Failed to create new plant variety.";
    }
}