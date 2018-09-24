package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.presentation.ActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyAddable;

/**
 *
 * @author zc
 */
public class AddGrowingMediumEventHandler extends ActionEventHandler<AddGrowingMediumDataModel> {

    public AddGrowingMediumEventHandler(AddGrowingMediumDataModel model) {
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