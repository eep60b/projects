package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.plant.GroupSelectable;
import com.etlsolutions.javafx.system.ProjectManager;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddPlantTypeDialogDataModel extends DataUnitDataModel implements Savable, Validatable, GroupSelectable {

    public static final String SELECTED_VARIETY_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.SELECTED_VARIETY_PROPERTY";

    private final ObservableList<PlantGroup> plantGroups;
    private PlantGroup selectedPlantGroup;
    
    private final ObservableList<PlantVariety> varieties;
    private PlantVariety selectedVariety;

    public AddPlantTypeDialogDataModel() {
        plantGroups = ProjectManager.getInstance().getProject().getPlantsGroupRoot().getPlantGroups();
        selectedPlantGroup = plantGroups.get(0);
        varieties = FXCollections.observableArrayList();
    }

    public ObservableList<PlantVariety> getVarieties() {
        return new ObservableListWrapper<>(varieties);
    }

    public PlantVariety getSelectedVariety() {
        return selectedVariety;
    }

    public void setSelectedVariety(PlantVariety selectedVariety) {
        PlantVariety oldValue = this.selectedVariety;
        this.selectedVariety = selectedVariety;
        support.firePropertyChange(SELECTED_VARIETY_PROPERTY, oldValue, this.selectedVariety);
    }

    @Override
    public void validate() {
        if (title == null || title.trim().isEmpty()) {
            errorMessage = "Enter the name.";
        }
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean isValid() {
        return errorMessage == null || errorMessage.trim().isEmpty();
    }

    public PlantGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    @Override
    public void setSelectedPlantGroup(PlantGroup selectedPlantGroup) {
        this.selectedPlantGroup = selectedPlantGroup;
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    @Override
    public void save() {
        
        PlantType type = PlantsFactory.creatPlantsType(title, information, varieties, imageLinks);        
        selectedPlantGroup.getPlantsTypes().add(type);
    }

    public void removeSelectedPlantVariety() {
        if(selectedVariety != null) {
            int index = varieties.indexOf(selectedVariety);
            varieties.remove(index);
            setSelectedVariety(varieties.isEmpty() ? null : varieties.get(index == 0 ? 0 : index -1));
        }
    }
}
