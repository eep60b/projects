package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantsGroup;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.system.ProjectManager;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PlantTypeDialogDataModel extends DataUnitDataModel implements Savable, Validatable {

    public static final String VARIETIES_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.VARIETIES_PROPERTY";
    public static final String SELECTED_VARIETY_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.SELECTED_VARIETY_PROPERTY";

    private ObservableList<PlantVariety> varieties;
    private PlantVariety selectedVariety;

    private final List<PlantsGroup> plantGroups;
    private PlantsGroup selectedPlantGroup;

    public PlantTypeDialogDataModel() {
        plantGroups = ProjectManager.getInstance().getProject().getPlantsGroupRoot().getPlantsGroups();
        selectedPlantGroup = plantGroups.get(0);
        varieties = new ObservableListWrapper<>(new ArrayList<PlantVariety>());
    }

    public ObservableList<PlantVariety> getVarieties() {
        return new ObservableListWrapper<>(varieties);
    }

    public void setVarieties(ObservableList<PlantVariety> varieties) {
        this.varieties = new ObservableListWrapper<>(varieties);
        support.firePropertyChange(VARIETIES_PROPERTY, false, true);
        if (this.varieties.isEmpty()) {
            setSelectedVariety(null);
        } else {
            setSelectedVariety(this.varieties.get(0));
        }
    }

    public boolean addVariety(PlantVariety variety) {
        
        boolean added = this.varieties.add(variety);
        if (added) {
            support.firePropertyChange(VARIETIES_PROPERTY, false, true);
            setSelectedVariety(variety);
        }

        return added;
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
        String title = getTitle();
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

    public PlantsGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    public void setSelectedPlantGroup(PlantsGroup selectedPlantGroup) {
        this.selectedPlantGroup = selectedPlantGroup;
    }

    public List<PlantsGroup> getPlantGroups() {
        return new ArrayList<>(plantGroups);
    }

    @Override
    public void save() {
        selectedPlantGroup.addPlantsType(PlantsFactory.creatPlantsType());
    }

    public void removeSelectedPlantVariety() {
        if(selectedVariety != null) {
            int index = varieties.indexOf(selectedVariety);
            varieties.remove(index);
            setSelectedVariety(varieties.isEmpty() ? null : varieties.get(index == 0 ? 0 : index -1));
        }
    }
}
