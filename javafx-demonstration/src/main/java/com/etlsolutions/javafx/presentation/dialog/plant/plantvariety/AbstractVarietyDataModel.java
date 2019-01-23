package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantVarietyValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.RemoveFromListUtil;

/**
 *
 * @author zc
 */
public abstract class AbstractVarietyDataModel extends DataUnitFXMLDataModel<PlantVariety> {

    public static final RemoveEventId REMOVE_ALIAS_ID = new RemoveEventId(AbstractVarietyDataModel.class.getName() + "REMOVE_ALIAS_ID", "alias");
  
    private final PlantVarietyValueWrapper valueWrapper;
    private final ValueWrapper<String> selectedAliasValueWrapper;

    public AbstractVarietyDataModel(PlantVarietyValueWrapper valueWrapper, ValueWrapper<String> selectedAliasValueWrapper) {
        this.valueWrapper = valueWrapper;
        this.selectedAliasValueWrapper = selectedAliasValueWrapper;
    }

    public ValueWrapper<String> getLatinNameValueWrapper() {
        return valueWrapper.getLatinNameValueWrapper();
    }

    public ObservableListWrapperA<String> getAliases() {
        return valueWrapper.getAliases();
    }

    public ValueWrapper<String> getSelectedAliasWalueWrapper() {
        return selectedAliasValueWrapper;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (id == REMOVE_ALIAS_ID) {
            RemoveFromListUtil.getInstance().remove(valueWrapper.getAliases(), selectedAliasValueWrapper);
        }
        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/PlantVarietyFXML.fxml";
    }

    @Override
    protected final PlantVarietyValueWrapper getValueWrapper() {
        return valueWrapper;
    } 
}
