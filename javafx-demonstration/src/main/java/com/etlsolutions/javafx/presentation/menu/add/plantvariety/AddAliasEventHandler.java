package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.ActionEventHandler;

/**
 *
 * @author zc
 */
class AddAliasEventHandler extends ActionEventHandler<VarietyDialogDataModel> {

    public AddAliasEventHandler(VarietyDialogDataModel parentModel) {
       super(parentModel);
    }

    @Override
    public String getFxmlFilePath() {
        return "/fxml/menu/add/AddVarietyAliasFXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "All Variety Alias";
    }

    @Override
    public String getErrorMessage() {
        return "Failed to create new plant variety alias.";
    }
}
