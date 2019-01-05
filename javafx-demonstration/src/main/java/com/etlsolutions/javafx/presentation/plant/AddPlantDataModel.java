package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddPlantDataModel extends AbstractPlantDataModel {


    private final ObservableListWrapperA<PlantGroup> plantGroups;
    private final ObservableListWrapperA<PlantSubGroup> plantSubGroups;
    private final ObservableListWrapperA<PlantVariety> plantVarieties;    

    /**
     * Construct an object.
     *
     * @throws IndexOutOfBoundsException if no plant group can be selected from
     * the plant group list.
     */
    public AddPlantDataModel() {

        ProjectContents pc = ProjectManager.getInstance().getContents();
        plantGroups = pc.getPlantsGroupRoot().getPlantGroups();
        plantSubGroups = new ObservableListWrapperA<>(plantValueWrapper.getPlantGroupValueWrapper().getValue().getPlantsSubGroups());
        plantVarieties = plantValueWrapper.getPlantSubGroupValueWrapper().getValue().getPlantVarieties();        
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantSubGroups() {
        return plantSubGroups;
    }

    public ValueWrapper<PlantGroup> getPlantGroupValueWrapper() {
        return plantValueWrapper.getPlantGroupValueWrapper();
    }

    public ValueWrapper<PlantSubGroup> getPlantSubGroupValueWrapper() {
        return plantValueWrapper.getPlantSubGroupValueWrapper();
    }
    

    public ObservableListWrapperA<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }
    
    public ValueWrapper<PlantVariety> getPlantVarietyValueWrapper() {
        return plantValueWrapper.getPlantVarietyValueWrapper();
    }    

    @Override
    public void save() {
        set(PlantsFactory.getInstance().creatPlant(getValueWrapper, plantValueWrapper));
        getPlantSubGroupValueWrapper().getValue().getPlantsList().add(get());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/AddPlantFXML.fxml";
    }
}
