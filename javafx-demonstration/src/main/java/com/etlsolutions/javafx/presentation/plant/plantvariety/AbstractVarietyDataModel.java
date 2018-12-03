package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.RemoveFromListUtil;

/**
 *
 * @author zc
 */
public abstract class AbstractVarietyDataModel extends DataUnitFXMLDataModel<PlantVariety> {

    public static final RemoveEventId REMOVE_ALIAS_ID = new RemoveEventId(AbstractVarietyDataModel.class.getName() + "REMOVE_ALIAS_ID", "alias");
  
    protected final ValueWrapper<String> latinNameValueWrapper;
    protected final ObservableListWrapperA<String> aliases;
    private final ValueWrapper<String> selectedAliasValueWrapper;


    public AbstractVarietyDataModel() {
        latinNameValueWrapper = new ValueWrapper<>("");
        aliases = new ObservableListWrapperA<>();
        selectedAliasValueWrapper = new ValueWrapper<>("");
    }

    public AbstractVarietyDataModel(PlantVariety variety) {
        super(variety);
        latinNameValueWrapper = new ValueWrapper<>(variety.getLatinName());
        aliases = new ObservableListWrapperA<>(variety.getAliases());
        selectedAliasValueWrapper = new ValueWrapper<>(aliases.isEmpty() ? "" : aliases.get(0));
    }

    public ValueWrapper<String> getLatinNameValueWrapper() {
        return latinNameValueWrapper;
    }

    public ObservableListWrapperA<String> getAliases() {
        return aliases;
    }

    public ValueWrapper<String> getSelectedAliasWalueWrapper() {
        return selectedAliasValueWrapper;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (id == REMOVE_ALIAS_ID) {
            RemoveFromListUtil.getInstance().remove(aliases, selectedAliasValueWrapper);
        }
        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/PlantVarietyFXML.fxml";
    }
}
