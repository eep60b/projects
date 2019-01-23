package com.etlsolutions.javafx.presentation.dialog.plantsubgroup;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class CreatePlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {

    private final ProjectManager manager = ProjectManager.getInstance();

    private final ObservableListWrapperA<PlantGroup> plantGroups;
    private final ValueWrapper<PlantGroup> selectedPlantGroupValueWrapper;

    public CreatePlantSubGroupDataModel() {
        super(PlantsFactory.getInstance().creatDefaultPlantSubGroupValueWrapper(ProjectManager.getInstance().getContents().getPlantsGroupRoot().getPlantGroups().get(0)));
        plantGroups = new ObservableListWrapperA<>(manager.getContents().getPlantsGroupRoot().getPlantGroups());
        selectedPlantGroupValueWrapper = new ValueWrapper<>(plantGroups.get(0));
    }


    public ValueWrapper<PlantGroup> getSelectedPlantGroupValueWrapper() {
        return selectedPlantGroupValueWrapper;
    }

    public ObservableListWrapperA<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    @Override
    public void save() {

        set(PlantsFactory.getInstance().creatPlantSubGroup(getValueWrapper()));
        selectedPlantGroupValueWrapper.getValue().getPlantSubGroups().add(get());
        manager.addItem(get());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/CreatePlantSubGroupFXML.fxml";
    }
}
