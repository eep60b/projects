package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

/**
 *
 * @author zc
 */
public class AddVarietyAliasDataModel extends AbstractVarietyAliasDataModel{

    public AddVarietyAliasDataModel(AbstractVarietyDataModel model) {
        super(model);
        getTitleValueWrapper().setValue("");
    }
   
    @Override
    public void save() {
        parentModel.getAliases().add(aliasValueWrapper.getValue());
        parentModel.getSelectedAliasWalueWrapper().setValue(aliasValueWrapper.getValue());
    }    
}
