package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint;
import com.etlsolutions.javafx.data.plant.PlantValueWrapper;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.RemoveFromListUtil;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractPlantDataModel extends DataUnitFXMLDataModel<Plants> {

    public static final RemoveEventId REMOVE_GVENT_ID = new RemoveEventId(AbstractPlantDataModel.class.getName() + "REMOVE_GVENT_ID", "event");
    public static final RemoveEventId REMOVE_TASK_ID = new RemoveEventId(AbstractPlantDataModel.class.getName() + "REMOVE_TASK_ID", "event");
    public static final RemoveEventId REMOVE_ISSUE_ID = new RemoveEventId(AbstractPlantDataModel.class.getName() + "REMOVE_ISSUE_ID", "event");
    public static final RemoveEventId REMOVE_OBSERVATION_ID = new RemoveEventId(AbstractPlantDataModel.class.getName() + "REMOVE_OBSERVATION_ID", "event");

    private final PlantValueWrapper valueWrapper;
    private final ObservableListWrapperA<GrowingMedium> growingMediums;    
    private final ValueWrapper<Gvent> selectedEventValueWrapper;
    private final ValueWrapper<GrowingIssue> selectedGrowingIssueValueWrapper;
    private final ValueWrapper<Task> selectedTaskValueWrapper;
    private final ValueWrapper<GrowingObservation> selectedGrowingObservationValueWrapper;


    public AbstractPlantDataModel(PlantValueWrapper plantValueWrapper) {

        this.valueWrapper = plantValueWrapper;
        ProjectContents pc = ProjectManager.getInstance().getContents();
        growingMediums = pc.getGrowingMediums();
        selectedEventValueWrapper = new ValueWrapper<>(plantValueWrapper.getGvents().isEmpty() ? null : plantValueWrapper.getGvents().get(0));
        selectedGrowingIssueValueWrapper = new ValueWrapper<>(plantValueWrapper.getGrowingIssues().isEmpty() ? null : plantValueWrapper.getGrowingIssues().get(0));
        selectedTaskValueWrapper = new ValueWrapper<>(plantValueWrapper.getTasks().isEmpty() ? null : plantValueWrapper.getTasks().get(0));
        selectedGrowingObservationValueWrapper = new ValueWrapper<>(plantValueWrapper.getGrowingObservations().isEmpty() ? null : plantValueWrapper.getGrowingObservations().get(0));
    }

    public ObservableListWrapperA<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    public ValueWrapper<Location> getLocationValueWrapper() {
        return valueWrapper.getLocationValueWrapper();
    }

    public ValueWrapper<Boolean> getIsAliveValueWrapper() {
        return valueWrapper.getIsAliveValueWrapper();
    }

    public ValueWrapper<GrowingStartPoint> getGrowingStartPointValueWrapper() {
        return valueWrapper.getGrowingStartPointValueWrapper();
    }

    public ValueWrapper<GrowingMedium> getGrowingMediumValueWrapper() {
        return valueWrapper.getGrowingMediumValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return valueWrapper.getStartTimeValueWrapper();
    }

    public ValueWrapper<Integer> getQuantityValueWrapper() {
        return valueWrapper.getQuantityValueWrapper();
    }

    public ValueWrapper<Type> getQuantityTypeValueWrapper() {
        return valueWrapper.getQuantityTypeValueWrapper();
    }

    public ValueWrapper<String> getTerminationReasonValueWrapper() {
        return valueWrapper.getTerminationReasonValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getTerminationTimeValueWrapper() {
        return valueWrapper.getTerminationTimeValueWrapper();
    }

    public ObservableListWrapperA<Gvent> getGvents() {
        return valueWrapper.getGvents();
    }

    public ObservableListWrapperA<GrowingIssue> getGrowingIssues() {
        return valueWrapper.getGrowingIssues();
    }

    public ObservableListWrapperA<GrowingObservation> getGrowingObservations() {
        return valueWrapper.getGrowingObservations();
    }

    public ObservableListWrapperA<Task> getTasks() {
        return valueWrapper.getTasks();
    }

    public ValueWrapper<Gvent> getSelectedGventValueWrapper() {
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
    public void remove(RemoveEventId id) {

        RemoveFromListUtil rfu = RemoveFromListUtil.getInstance();

        if (id == REMOVE_GVENT_ID) {
            rfu.remove(getGvents(), selectedEventValueWrapper);
        }

        if (id == REMOVE_TASK_ID) {
            rfu.remove(getTasks(), selectedTaskValueWrapper);
        }

        if (id == REMOVE_ISSUE_ID) {
            rfu.remove(getGrowingIssues(), selectedGrowingIssueValueWrapper);
        }

        if (id == REMOVE_OBSERVATION_ID) {
            rfu.remove(getGrowingObservations(), selectedGrowingObservationValueWrapper);
        }

        super.remove(id);
    }

    @Override
    protected final PlantValueWrapper getValueWrapper() {
        return valueWrapper;
    }

}
