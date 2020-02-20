package com.etlsolutions.javafx.presentation.dialog.plantgroup;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantGroupValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;

/**
 *
 * @author zc
 */
public abstract class AbstractPlantGroupDataModel extends DataUnitFXMLDataModel<PlantGroup> {

    private final PlantGroupValueWrapper valueWrapper;
    protected final ObservableListWrapperA<PlantSubGroup> plantSubGroups;
    private final ValueWrapper<PlantSubGroup> selectedPlantSubGroup;

    public AbstractPlantGroupDataModel(PlantGroupValueWrapper valueWrapper) {
        this.valueWrapper = valueWrapper;
        plantSubGroups = valueWrapper.getPlantsSubGroups();
        selectedPlantSubGroup = new ValueWrapper<>(plantSubGroups.isEmpty() ? null : plantSubGroups.get(0));
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantSubGroups() {
        return plantSubGroups;
    }

    public ValueWrapper<PlantSubGroup> getSelectedPlantSubGroup() {
        return selectedPlantSubGroup;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/PlantGroupFXML.fxml";
    }

    @Override
    public PlantGroupValueWrapper getValueWrapper() {
        return valueWrapper;
    }
}
