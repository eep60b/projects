package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class CreateRootedPlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {
    
    private final ObservableListWrapperA<PlantGroup> plantGroups;
    
    public CreateRootedPlantSubGroupDataModel() {
        
        super(PlantsFactory.getInstance().creatDefaultPlantSubGroupValueWrapper(ProjectManager.getInstance().getContents().getPlantsGroupRoot().getPlantGroups().get(0)));
        plantGroups = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getPlantsGroupRoot().getPlantGroups());
    }

    public ValueWrapper<PlantGroup> getSelectedPlantGroupValueWrapper() {
        return getValueWrapper().getPlantGroupValueWrapper();
    }

    public ObservableListWrapperA<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    @Override
    public void save() {

        set(PlantsFactory.getInstance().creatPlantSubGroup(getValueWrapper()));
        getSelectedPlantGroupValueWrapper().getValue().getPlantSubGroups().add(get());
        ProjectManager.getInstance().addItem(get());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/CreateRootedPlantSubGroupFXML.fxml";
    }
}
