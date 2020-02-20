package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.gwise.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class EditVarietyAliasDataModel extends AbstractVarietyAliasDataModel {

    private final ObservableListWrapperA<String> aliases;

    public EditVarietyAliasDataModel(AbstractVarietyDataModel model) {
        super(model);
        aliases = model.getAliases();
    }

    @Override
    public boolean isInvalid() {

        if (aliases.contains(getTitleValueWrapper().getValue())) {
            return true;
        }

        return super.isInvalid();
    }

    @Override
    public String getErrorMessage() {
        
        if (aliases.contains(getTitleValueWrapper().getValue())) {
            return "This alias exists already.";
        }
        return super.getErrorMessage();
    }
    
    @Override
    public void save() {
        parentModel.getSelectedAliasWalueWrapper().setValue(aliasValueWrapper.getValue());
    }    
}
