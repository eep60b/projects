package com.etlsolutions.javafx.presentation.menu.edit.plantvariety;

import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AbstractVarietyDataModel;

/**
 *
 * @author zc
 */
public class EditPlantVarietyAliasDataModel implements TitleDataModel, InformationDataModel, Validatable, Savable {

    private final AbstractVarietyDataModel parentModel;
    private String title;
    private final String oldTitle;

    public EditPlantVarietyAliasDataModel(AbstractVarietyDataModel parentModel) {
        this.parentModel = parentModel;
        oldTitle = title = parentModel.getSelectedAlias();
    }


    @Override
    public void save() {

        if (oldTitle == null || oldTitle.trim().isEmpty()) {
            parentModel.addAlias(title);
        } else {
   //         parentModel.replaceAlias(oldTitle, title);
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

   
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public String getFxmlPath() {
        return "/fxml/menu/add/AddVarietyAliasFXML.fxml";
    }

    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInformation(String information) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInformationValueWrapper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
