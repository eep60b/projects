package com.etlsolutions.javafx.presentation.dialog.plantsubgroup;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.gwise.system.ProjectManager;

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
        getSelectedPlantGroupValueWrapper().getValue().getPlantSubGroups().add(getItem());
        ProjectManager.getInstance().addItem(getItem());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/CreateRootedPlantSubGroupFXML.fxml";
    }
}
