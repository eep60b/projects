package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantValueWrapper;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddPlantsDataModel extends DataUnitFXMLDataModel<Plants> {
    
    public static final RemoveEventId REMOVE_GVENT_ID = new RemoveEventId(AddPlantsDataModel.class.getName() + "REMOVE_GVENT_ID", "event");
    
    private final ObservableList<PlantGroup> plantGroups;
    private final ObservableListWrapperA<PlantSubGroup> plantTypes;
    private final ObservableList<GrowingMedium> growingMediums;
    private final ObservableList<PlantVariety> plantVarieties;

    private final PlantValueWrapper plantValueWrapper;

    private final ValueWrapper<Gvent> selectedEventValueWrapper;
    private final ValueWrapper<GrowingIssue> selectedGrowingIssueValueWrapper;
    private final ValueWrapper<Task> selectedTaskValueWrapper;
    private final ValueWrapper<GrowingObservation> selectedGrowingObservationValueWrapper;

    /**
     * Construct an object.
     *
     * @throws IndexOutOfBoundsException if no plant group can be selected from
     * the plant group list.
     */
    public AddPlantsDataModel() {

        ProjectContents pc = ProjectManager.getInstance().getContents();
        plantGroups = pc.getPlantsGroupRoot().getPlantGroups();
        growingMediums = pc.getGrowingMediums();
        plantValueWrapper = new PlantValueWrapper();
        plantTypes = new ObservableListWrapperA<>(plantValueWrapper.getPlantGroupValueWrapper().getValue().getPlantsSubGroups());
        plantVarieties = plantValueWrapper.getPlantSubGroupValueWrapper().getValue().getPlantVarieties();
        selectedEventValueWrapper = new ValueWrapper<>(plantValueWrapper.getGvents().isEmpty() ? null : plantValueWrapper.getGvents().get(0));
        selectedGrowingIssueValueWrapper = new ValueWrapper<>(plantValueWrapper.getGrowingIssues().isEmpty() ? null : plantValueWrapper.getGrowingIssues().get(0));
        selectedTaskValueWrapper = new ValueWrapper<>(plantValueWrapper.getTasks().isEmpty() ? null : plantValueWrapper.getTasks().get(0));
        selectedGrowingObservationValueWrapper = new ValueWrapper<>(plantValueWrapper.getGrowingObservations().isEmpty() ? null : plantValueWrapper.getGrowingObservations().get(0));
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    public ObservableListWrapperA<PlantSubGroup> getPlantTypes() {
        return plantTypes;
    }

    public ObservableList<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    public ObservableList<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    public ValueWrapper<PlantGroup> getPlantGroupValueWrapper() {
        return plantValueWrapper.getPlantGroupValueWrapper();
    }

    public ValueWrapper<PlantSubGroup> getPlantSubGroupValueWrapper() {
        return plantValueWrapper.getPlantSubGroupValueWrapper();
    }

    public ValueWrapper<Location> getLocationValueWrapper() {
        return plantValueWrapper.getLocationValueWrapper();
    }

    public ValueWrapper<Boolean> getIsAliveValueWrapper() {
        return plantValueWrapper.getIsAliveValueWrapper();
    }

    public ValueWrapper<GrowingStartPoint> getGrowingStartPointValueWrapper() {
        return plantValueWrapper.getGrowingStartPointValueWrapper();
    }

    public ValueWrapper<GrowingMedium> getGrowingMediumValueWrapper() {
        return plantValueWrapper.getGrowingMediumValueWrapper();
    }

    public ValueWrapper<PlantVariety> getPlantVarietyValueWrapper() {
        return plantValueWrapper.getPlantVarietyValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return plantValueWrapper.getStartTimeValueWrapper();
    }

    public ValueWrapper<Integer> getQuantityValueWrapper() {
        return plantValueWrapper.getQuantityValueWrapper();
    }

    public ValueWrapper<Type> getQuantityTypeValueWrapper() {
        return plantValueWrapper.getQuantityTypeValueWrapper();
    }

    public ValueWrapper<String> getTerminationReasonValueWrapper() {
        return plantValueWrapper.getTerminationReasonValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getTerminationTimeValueWrapper() {
        return plantValueWrapper.getTerminationTimeValueWrapper();
    }

    public ObservableListWrapperA<Gvent> getGvents() {
        return plantValueWrapper.getGvents();
    }

    public ObservableListWrapperA<GrowingIssue> getGrowingIssues() {
        return plantValueWrapper.getGrowingIssues();
    }

    public ObservableListWrapperA<GrowingObservation> getGrowingObservations() {
        return plantValueWrapper.getGrowingObservations();
    }

    public ObservableListWrapperA<Task> getTasks() {
        return plantValueWrapper.getTasks();
    }

    public ValueWrapper<Gvent> getSelectedEventValueWrapper() {
        return selectedEventValueWrapper;
    }

    public ValueWrapper<GrowingIssue> getSelectedGrowingIssueValueWrapper() {
        return selectedGrowingIssueValueWrapper;
    }

    public ValueWrapper<Task> getSelectedTaskValueWrapper() {
        return selectedTaskValueWrapper;
    }

    public ValueWrapper<GrowingObservation> getSelectedGrowingObservationValueWrapper() {
        return selectedGrowingObservationValueWrapper;
    }

    @Override
    public void save() {
        dataUnit = PlantsFactory.getInstance().creatPlant(commonValueWrapper, plantValueWrapper);
        getPlantSubGroupValueWrapper().getValue().getPlantsList().add(dataUnit);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddPlantsFXML.fxml";
    }
}
