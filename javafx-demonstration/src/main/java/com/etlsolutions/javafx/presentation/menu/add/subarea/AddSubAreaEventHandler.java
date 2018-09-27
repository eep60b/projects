package com.etlsolutions.javafx.presentation.menu.add.subarea;

import com.etlsolutions.javafx.presentation.ActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.location.AddLocationWizardDataModel;

/**
 *
 * @author zc
 */
public class AddSubAreaEventHandler extends ActionEventHandler<AddLocationWizardDataModel> {

    private final String typeTitle;

    public AddSubAreaEventHandler(AddLocationWizardDataModel parentModel) {
        super(parentModel);
        typeTitle = parentModel.getSelectedSubAreaType().getTitle();
    }

    @Override
    public String getFxmlFilePath() {

        return "/fxml/menu/add/Add" + typeTitle.replace(" ", "") + "FXML.fxml";
    }

    @Override
    public String getStageTitle() {
        return "Add " + typeTitle;
    }

    @Override
    public String getErrorMessage() {
        return "Failed to add " + typeTitle;
    }

}
