package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;
import java.util.Calendar;
import static java.util.Calendar.*;

/**
 *
 * @author zc
 */
public class PlantValueWrapper {

    private final ValueWrapper<PlantGroup> plantGroupValueWrapper;
    private final ValueWrapper<PlantSubGroup> plantSubGroupValueWrapper;
    private final ValueWrapper<Location> locationValueWrapper;
    private final ValueWrapper<Boolean> isAliveValueWrapper;
    private final ValueWrapper<GrowingStartPoint> growingStartPointValueWrapper;
    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<GrowingMedium> growingMediumValueWrapper;
    private final ValueWrapper<PlantVariety> plantVarietyValueWrapper;
    private final ValueWrapper<Integer> quantityValueWrapper;
    private final ValueWrapper<PlantsQuantity.Type> quantityTypeValueWrapper;
    private final ValueWrapper<String> terminationReasonValueWrapper; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
    private final ValueWrapper<LocalDateTime> terminationTimeValueWrapper;
    private final ObservableListWrapperA<Gvent> gvents;
    private final ObservableListWrapperA<GrowingIssue> growingIssues;
    private final ObservableListWrapperA<GrowingObservation> growingObservations;
    private final ObservableListWrapperA<Task> tasks;

    public PlantValueWrapper() {
        ProjectContents pc = ProjectManager.getInstance().getContents();
        PlantGroup pg = pc.getPlantsGroupRoot().getPlantGroups().get(0);
        plantGroupValueWrapper = new ValueWrapper<>(pg);
        PlantSubGroup sg = pg.getPlantsSubGroups().get(0);
        plantSubGroupValueWrapper = new ValueWrapper<>(sg);
        locationValueWrapper = new ValueWrapper<>(null);
        isAliveValueWrapper = new ValueWrapper<>(true);
        growingStartPointValueWrapper = new ValueWrapper<>(GrowingStartPoint.SEED);
        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        growingMediumValueWrapper = new ValueWrapper<>(pc.getGrowingMediums().get(0));
        plantVarietyValueWrapper = new ValueWrapper<>(sg.getPlantVarieties().get(0));
        quantityValueWrapper = new ValueWrapper<>(0);
        quantityTypeValueWrapper = new ValueWrapper<>(PlantsQuantity.Type.SINGLE);
        terminationReasonValueWrapper = new ValueWrapper<>("");
        terminationTimeValueWrapper = new ValueWrapper<>(LocalDateTime.MAX);
        gvents = new ObservableListWrapperA<>();
        growingIssues = new ObservableListWrapperA<>();
        growingObservations = new ObservableListWrapperA<>();
        tasks = new ObservableListWrapperA<>();
    }

    public PlantValueWrapper(Plants plant) {
        
        ProjectManager pm = ProjectManager.getInstance();
        PlantSubGroup ps = pm.<PlantSubGroup>getItem(plant.getPlantSubGroupId());
        plantSubGroupValueWrapper = new ValueWrapper<>(ps);
        plantGroupValueWrapper = new ValueWrapper<>(pm.<PlantGroup>getItem(ps.getPlantGroupId()));
        locationValueWrapper = new ValueWrapper<>(pm.<Location>getItem(plant.getLocationId()));
        isAliveValueWrapper = new ValueWrapper<>(plant.isAlive());
        growingStartPointValueWrapper = new ValueWrapper<>(plant.getGrowingStartPoint());
        Calendar c = Calendar.getInstance();
        c.setTime(plant.getStartTime());
        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.of(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH), c.get(HOUR), c.get(MINUTE)));
        growingMediumValueWrapper = new ValueWrapper<>(pm.<GrowingMedium>getItem(plant.getGrowingMediumId()));
        plantVarietyValueWrapper = new ValueWrapper<>(pm.<PlantVariety>getItem(plant.getPlantVarietyId()));
        quantityValueWrapper = new ValueWrapper<>(plant.getQuantity());
        quantityTypeValueWrapper = new ValueWrapper<>(plant.getQuantityType());
        terminationReasonValueWrapper = new ValueWrapper<>(plant.getTerminationReason());
        c.setTime(plant.getTerminationTime());
        terminationTimeValueWrapper = new ValueWrapper<>(LocalDateTime.of(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH), c.get(HOUR), c.get(MINUTE)));

        gvents = new ObservableListWrapperA<>();
        for (int i : plant.getEventIds()) {
            gvents.add(pm.<Gvent>getItem(i));
        }

        growingIssues = new ObservableListWrapperA<>();
        for (int i : plant.getEventIds()) {
            growingIssues.add(pm.<GrowingIssue>getItem(i));
        }

        growingObservations = new ObservableListWrapperA<>();
        for (int i : plant.getEventIds()) {
            growingObservations.add(pm.<GrowingObservation>getItem(i));
        }
        tasks = new ObservableListWrapperA<>();
        for (int i : plant.getEventIds()) {
            tasks.add(pm.<Task>getItem(i));
        }
    }

    public ValueWrapper<PlantGroup> getPlantGroupValueWrapper() {
        return plantGroupValueWrapper;
    }

    public ValueWrapper<PlantSubGroup> getPlantSubGroupValueWrapper() {
        return plantSubGroupValueWrapper;
    }

    public ValueWrapper<Location> getLocationValueWrapper() {
        return locationValueWrapper;
    }
    
    public ValueWrapper<Boolean> getIsAliveValueWrapper() {
        return isAliveValueWrapper;
    }

    public ValueWrapper<GrowingStartPoint> getGrowingStartPointValueWrapper() {
        return growingStartPointValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    public ValueWrapper<GrowingMedium> getGrowingMediumValueWrapper() {
        return growingMediumValueWrapper;
    }

    public ValueWrapper<PlantVariety> getPlantVarietyValueWrapper() {
        return plantVarietyValueWrapper;
    }

    public ValueWrapper<Integer> getQuantityValueWrapper() {
        return quantityValueWrapper;
    }

    public ValueWrapper<PlantsQuantity.Type> getQuantityTypeValueWrapper() {
        return quantityTypeValueWrapper;
    }

    public ValueWrapper<String> getTerminationReasonValueWrapper() {
        return terminationReasonValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getTerminationTimeValueWrapper() {
        return terminationTimeValueWrapper;
    }

    public ObservableListWrapperA<Gvent> getGvents() {
        return gvents;
    }

    public ObservableListWrapperA<GrowingIssue> getGrowingIssues() {
        return growingIssues;
    }

    public ObservableListWrapperA<GrowingObservation> getGrowingObservations() {
        return growingObservations;
    }

    public ObservableListWrapperA<Task> getTasks() {
        return tasks;
    }
}
