package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.plant.GroupSelectable;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Objects;

/**
 *
 * @author zc
 */
public class AddPlantTypeDataModel extends DataUnitFXMLDataModel implements GroupSelectable {

    public static final String SELECTED_VARIETY_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.SELECTED_VARIETY_PROPERTY";
    public static final String VARIETY_CHANGE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.VARIETY_CHANGE_PROPERTY";

    
    public static final RemoveEventId REMOVE_VARIETY_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDataModel.REMOVE_VARIETY_ID", "plant variety");

    private final ProjectManager manager = ProjectManager.getInstance();
    
    private final ObservableListWrapperA<PlantGroup> plantGroups;
    private PlantGroup selectedPlantGroup;
    
    private PlantType plantType;
    
    private final ObservableListWrapperA<PlantVariety> varieties;
    private PlantVariety selectedVariety;

    public AddPlantTypeDataModel() {
        plantGroups = new ObservableListWrapperA<>(manager.getProject().getPlantsGroupRoot().getPlantGroups());
        selectedPlantGroup = plantGroups.get(0);
        varieties = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<PlantVariety> getVarieties() {
        return varieties;
    }

    public PlantVariety getSelectedVariety() {
        return selectedVariety;
    }

    public void setSelectedVariety(PlantVariety selectedVariety) {
        PlantVariety oldValue = this.selectedVariety;
        this.selectedVariety = selectedVariety;
        support.firePropertyChange(SELECTED_VARIETY_PROPERTY, oldValue, this.selectedVariety);
    }

    public PlantGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    @Override
    public void setSelectedPlantGroup(PlantGroup selectedPlantGroup) {
        this.selectedPlantGroup = selectedPlantGroup;
    }

    public ObservableListWrapperA<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    @Override
    public void save() {
        
        plantType = PlantsFactory.getInstance().creatPlantsType(title, information, varieties, imageLinks);        
        selectedPlantGroup.getPlantsTypes().add(plantType);
        manager.addItem(plantType);
    }

    public void addSelectedPlantVariety(PlantVariety variety) {        
        varieties.add(variety);
        setSelectedVariety(variety);
    }

    @Override
    public void remove(RemoveEventId id) {
        
        if(Objects.equals(id, REMOVE_VARIETY_ID)) {
          removeSelectedPlantVariety();
        }
        
        super.remove(id); 
    }
    
    
    
    private void removeSelectedPlantVariety() {
        
        if(selectedVariety != null) {
            int index = varieties.indexOf(selectedVariety);
            varieties.remove(index);
            setSelectedVariety(varieties.isEmpty() ? null : varieties.get(index == 0 ? 0 : index -1));
        }
    }

    @Override
    public String getFxmlPath() {
          return "/fxml/menu/add/AddPlantTypeFXML.fxml";
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void updateVariety() {
        support.firePropertyChange(VARIETY_CHANGE_PROPERTY);
    }
}
