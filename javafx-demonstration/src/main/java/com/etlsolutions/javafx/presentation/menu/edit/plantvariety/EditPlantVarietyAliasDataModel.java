package com.etlsolutions.javafx.presentation.menu.edit.plantvariety;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyDialogDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.etlsolutions.javafx.presentation.Addable;

/**
 *
 * @author zc
 */
public class EditPlantVarietyAliasDataModel extends DataUnitFXMLDataModel {

    private final AddVarietyDialogDataModel parentModel;
    private final String oldTitle;

    public EditPlantVarietyAliasDataModel(AddVarietyDialogDataModel parentModel) {
        this.parentModel = parentModel;
        oldTitle = title = parentModel.getSelectedAlias();
    }


    @Override
    public void add() {

        if (oldTitle == null || oldTitle.trim().isEmpty()) {
            parentModel.addAlias(title);
        } else {
            parentModel.replaceAlias(oldTitle, title);
        }

    }

    @Override
    public boolean isValid() {
        return title != null && !title.trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {

        if (isValid()) {
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
