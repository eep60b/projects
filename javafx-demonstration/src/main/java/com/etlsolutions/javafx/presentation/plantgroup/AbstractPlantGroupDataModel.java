package com.etlsolutions.javafx.presentation.plantgroup;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;

/**
 *
 * @author zc
 */
public abstract class AbstractPlantGroupDataModel extends DataUnitFXMLDataModel<PlantGroup> {

    protected final ObservableListWrapperA<PlantSubGroup> plantSubGroups;
    private final ValueWrapper<PlantSubGroup> selectedPlantSubGroup;

    public AbstractPlantGroupDataModel() {
        plantSubGroups = new ObservableListWrapperA<>();
        selectedPlantSubGroup = new ValueWrapper<>(null);
    }

    public AbstractPlantGroupDataModel(PlantGroup item) {
        super(item);
        plantSubGroups = new ObservableListWrapperA<>(item.getPlantsSubGroups());
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
}
