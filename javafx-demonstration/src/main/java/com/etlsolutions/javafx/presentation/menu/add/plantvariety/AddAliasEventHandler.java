package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.AbstractActionEventHandler;

/**
 *
 * @author zc
 */
public class AddAliasEventHandler extends AbstractActionEventHandler<VarietyDialogDataModel> {

    public AddAliasEventHandler(VarietyDialogDataModel parentModel) {
       super(parentModel);
    }

    @Override
    public String getFxmlFilePath() {
        return "/fxml/menu/add/AddVarietyAliasFXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "Add Variety Alias";
    }

    @Override
    public String getErrorMessage() {
        return "Failed to create new plant variety alias.";
    }
}
