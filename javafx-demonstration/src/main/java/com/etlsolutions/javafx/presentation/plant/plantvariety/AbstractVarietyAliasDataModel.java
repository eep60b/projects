package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import com.etlsolutions.javafx.presentation.Validatable;

/**
 *
 * @author zc
 */
public abstract class AbstractVarietyAliasDataModel implements TitleDataModel, Validatable, Savable, FXMLActionDataModel {
    
    private final AbstractVarietyDataModel parentModel;
    private final ValueWrapper<String> aliasValueWrapper;

    public AbstractVarietyAliasDataModel(AbstractVarietyDataModel parentModel) {
        this.parentModel = parentModel;
        aliasValueWrapper = new ValueWrapper<>(parentModel.getSelectedAliasWalueWrapper().getValue());
    }
    
    @Override
    public boolean isInvalid() {
        String alias = aliasValueWrapper.getValue();        
        return alias == null || alias.trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {

        if (isInvalid()) {
            return "";
        }
        return "Please enter alias name.";
    }
    
    @Override
    public ValueWrapper<String> getTitleValueWrapper() {
        return aliasValueWrapper;
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/VarietyAliasFXML.fxml";
    }    

    @Override
    public void save() {
        parentModel.getSelectedAliasWalueWrapper().setValue(aliasValueWrapper.getValue());
    }
}
