package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;

/**
 * The plantValueWrapper class contains all the information about a set of
 * plants.
 *
 * @author zc
 */
public class PlantValueWrapper extends DataUnitValueWrapper {

    private final Calendar c = Calendar.getInstance();

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

    public PlantValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLink, String logoPath, PlantGroup plantGroup, PlantSubGroup plantSubGroup,
            Location location, boolean isAlive, GrowingStartPoint growingStartPoint, LocalDateTime startTime, GrowingMedium growingMedium, PlantVariety plantVariety, int quantity, PlantsQuantity.Type quantityType, String terminationReason, LocalDateTime terminationTime, ObservableListWrapperA<Gvent> gvents, ObservableListWrapperA<GrowingIssue> growingIssues, ObservableListWrapperA<GrowingObservation> growingObservations, ObservableListWrapperA<Task> tasks) {
        super(title, information, imageLinks, selectedImgLink, logoPath);
        plantGroupValueWrapper = new ValueWrapper<>(plantGroup);
        plantSubGroupValueWrapper = new ValueWrapper<>(plantSubGroup);
        locationValueWrapper = new ValueWrapper<>(location);
        isAliveValueWrapper = new ValueWrapper<>(isAlive);
        growingStartPointValueWrapper = new ValueWrapper<>(growingStartPoint);
        startTimeValueWrapper = new ValueWrapper<>(startTime);
        growingMediumValueWrapper = new ValueWrapper<>(growingMedium);
        plantVarietyValueWrapper = new ValueWrapper<>(plantVariety);
        quantityValueWrapper = new ValueWrapper<>(quantity);
        quantityTypeValueWrapper = new ValueWrapper<>(quantityType);
        terminationReasonValueWrapper = new ValueWrapper<>(terminationReason);
        terminationTimeValueWrapper = new ValueWrapper<>(terminationTime);
        this.gvents = new ObservableListWrapperA<>(gvents);
        this.growingIssues = new ObservableListWrapperA<>(growingIssues);
        this.growingObservations = new ObservableListWrapperA<>(growingObservations);
        this.tasks = new ObservableListWrapperA<>(tasks);
    }

    public PlantValueWrapper(Plants plant) {

        super(plant);
        ProjectManager pm = ProjectManager.getInstance();
        PlantSubGroup ps = pm.<PlantSubGroup>getItem(plant.getPlantSubGroupId());
        plantSubGroupValueWrapper = new ValueWrapper<>(ps);
        plantGroupValueWrapper = new ValueWrapper<>(pm.<PlantGroup>getItem(ps.getPlantGroupId()));
        locationValueWrapper = new ValueWrapper<>(pm.<Location>getItem(plant.getLocationId()));
        isAliveValueWrapper = new ValueWrapper<>(plant.isAlive());
        growingStartPointValueWrapper = new ValueWrapper<>(plant.getGrowingStartPoint());
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
        for (int i : plant.getGventIds()) {
            gvents.add(pm.<Gvent>getItem(i));
        }

        growingIssues = new ObservableListWrapperA<>();
        for (int i : plant.getGventIds()) {
            growingIssues.add(pm.<GrowingIssue>getItem(i));
        }

        growingObservations = new ObservableListWrapperA<>();
        for (int i : plant.getGventIds()) {
            growingObservations.add(pm.<GrowingObservation>getItem(i));
        }
        tasks = new ObservableListWrapperA<>();
        for (int i : plant.getGventIds()) {
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

    public Date getStartTime() {

        LocalDateTime st = startTimeValueWrapper.getValue();
        c.set(st.getYear(), st.getMonthValue(), st.getDayOfMonth(), st.getHour(), st.getMinute());
        return c.getTime();
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

    public Date getTerminationTime() {
        LocalDateTime t = terminationTimeValueWrapper.getValue();
        c.set(t.getYear(), t.getMonthValue(), t.getDayOfMonth(), t.getHour(), t.getMinute());
        return c.getTime();
    }

    public ObservableListWrapperA<Gvent> getGvents() {
        return gvents;
    }

    public ObservableListWrapperA<Integer> getGventIds() {
        return getIds(gvents);
    }

    public ObservableListWrapperA<GrowingIssue> getGrowingIssues() {
        return growingIssues;
    }

    public ObservableListWrapperA<Integer> getGrowingIssueIds() {
        return getIds(growingIssues);
    }

    public ObservableListWrapperA<GrowingObservation> getGrowingObservations() {
        return growingObservations;
    }

    public ObservableListWrapperA<Integer> getGrowingObservationIds() {
        return getIds(growingObservations);
    }

    public ObservableListWrapperA<Task> getTasks() {
        return tasks;
    }

    public ObservableListWrapperA<Integer> getTaskIds() {
        return getIds(tasks);
    }

    private <L extends Log> ObservableListWrapperA<Integer> getIds(ObservableListWrapperA<L> logs) {

        ObservableListWrapperA<Integer> list = new ObservableListWrapperA<>();
        for (Log log : logs) {
            list.add(log.getId());
        }
        return list;
    }
}
