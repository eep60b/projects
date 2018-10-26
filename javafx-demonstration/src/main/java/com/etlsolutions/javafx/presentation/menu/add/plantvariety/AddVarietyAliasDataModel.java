package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.Validatable;

/**
 *
 * @author zc
 */
public class AddVarietyAliasDataModel extends DataUnitFXMLDataModel implements Validatable {

    private final AddVarietyDialogDataModel parentModel;
    private final String oldTitle;

 
    public AddVarietyAliasDataModel(AddVarietyDialogDataModel parentModel) {
        this.parentModel = parentModel;
        oldTitle = title = parentModel.getSelectedAlias();
    }

    @Override
    public void save() {

        if (oldTitle == null || oldTitle.trim().isEmpty()) {
            parentModel.addAlias(title);
        } else {
            parentModel.replaceAlias(oldTitle, title);
        }

    }

    @Override
    public boolean isInvalid() {
        return title != null && !title.trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {

        if (isInvalid()) {
            return "";
        }

        return "Please enter alias name.";
    }

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddVarietyAliasFXML.fxml";
    }

}
