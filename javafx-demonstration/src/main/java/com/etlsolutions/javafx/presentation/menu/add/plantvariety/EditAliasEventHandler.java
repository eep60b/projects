package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.ActionEventHandler;

/**
 *
 * @author zc
 */
public class EditAliasEventHandler extends ActionEventHandler<VarietyDialogDataModel> {

    public EditAliasEventHandler(VarietyDialogDataModel parentModel) {
       super(parentModel);
    }

    @Override
    public String getFxmlFilePath() {
        return "/fxml/menu/add/AddVarietyAliasFXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "Edit Variety Alias";
    }

    @Override
    public String getErrorMessage() {
        return "Failed to modify new plant variety alias.";
    }
}
