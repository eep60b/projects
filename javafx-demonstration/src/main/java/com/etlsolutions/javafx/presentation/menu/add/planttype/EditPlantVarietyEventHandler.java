package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.presentation.ActionEventHandler;

/**
 *
 * @author zc
 */
public class EditPlantVarietyEventHandler extends ActionEventHandler<PlantTypeDialogDataModel> {

    public EditPlantVarietyEventHandler(PlantTypeDialogDataModel model) {
        super(model);
    }

    @Override
    public String getFxmlFilePath() {
        return "/fxml/menu/add/AddPlantVarietyDialogFXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "Edit Plant Variety";
    }

    @Override
    public String getErrorMessage() {
        return "Failed to create modify the selected plant variety.";
    }
}