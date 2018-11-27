package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Each object of the Plants class represents a set of plants with an identical
 * variety which are planted in the same time and under the same condition. They
 * should be treated in the same way all the time. If anything is going to be
 * set differently, a new object should be used.
 *
 * @author zc
 */
public class Plants extends DataUnit {

    @JsonIgnore
    public static final String VARIEETY_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.VARIEETY_PROPERTY";
    @JsonIgnore
    public static final String QUANTITY_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.QUANTITY_PROPERTY";
    @JsonIgnore
    public static final String GROWING_DETAILS_PROPERTY = "com.etlsolutions.javafx.data.plant.Plants.GROWING_DETAILS_PROPERTY";

    private int plantSubGroupId;
    private int locationId;
    private boolean alive;
    private GrowingStartPoint growingStartPoint;
    private Date startTime;
    private int growingMediumId;
    private int plantVarietyId;
    private int quantity;
    private PlantsQuantity.Type quantityType;
    private String terminationReason; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
    private Date terminationTime;
    private ObservableListWrapperA<Integer> eventIds;
    private ObservableListWrapperA<Integer> issueIds;
    private ObservableListWrapperA<Integer> observationIds;
    private ObservableListWrapperA<Integer> taskIds;

    public Plants() {
    }

    public Plants(DataUnitValueWrapper valueWrapper, PlantValueWrapper plantValueWrapper) {
        super(valueWrapper);
        plantSubGroupId = plantValueWrapper.getPlantSubGroupValueWrapper().getValue().getId();
        locationId = plantValueWrapper.getLocationValueWrapper().getValue().getId();
        alive = plantValueWrapper.getIsAliveValueWrapper().getValue();
        growingStartPoint = plantValueWrapper.getGrowingStartPointValueWrapper().getValue();
        Calendar c = Calendar.getInstance();
        LocalDateTime st = plantValueWrapper.getStartTimeValueWrapper().getValue();
        c.set(st.getYear(), st.getMonthValue(), st.getDayOfMonth(), st.getHour(), st.getMinute());
        startTime = c.getTime();
        plantVarietyId = plantValueWrapper.getPlantVarietyValueWrapper().getValue().getId();
        quantity = plantValueWrapper.getQuantityValueWrapper().getValue();
        quantityType = plantValueWrapper.getQuantityTypeValueWrapper().getValue();
        terminationReason = plantValueWrapper.getTerminationReasonValueWrapper().getValue();
        LocalDateTime t = plantValueWrapper.getStartTimeValueWrapper().getValue();
        c.set(t.getYear(), t.getMonthValue(), t.getDayOfMonth(), t.getHour(), t.getMinute());
        terminationTime = c.getTime();
    }

    public int getPlantSubGroupId() {
        return plantSubGroupId;
    }

    public void setPlantSubGroupId(int plantSubGroupId) {
        this.plantSubGroupId = plantSubGroupId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public GrowingStartPoint getGrowingStartPoint() {
        return growingStartPoint;
    }

    public void setGrowingStartPoint(GrowingStartPoint growingStartPoint) {
        this.growingStartPoint = growingStartPoint;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getGrowingMediumId() {
        return growingMediumId;
    }

    public void setGrowingMediumId(int growingMediumId) {
        this.growingMediumId = growingMediumId;
    }

    public int getPlantVarietyId() {
        return plantVarietyId;
    }

    public void setPlantVarietyId(int plantVarietyId) {
        this.plantVarietyId = plantVarietyId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PlantsQuantity.Type getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(PlantsQuantity.Type quantityType) {
        this.quantityType = quantityType;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public Date getTerminationTime() {
        return terminationTime;
    }

    public void setTerminationTime(Date terminationTime) {
        this.terminationTime = terminationTime;
    }

    public ObservableListWrapperA<Integer> getEventIds() {
        return eventIds;
    }

    public void setEventIds(ObservableListWrapperA<Integer> eventIds) {
        this.eventIds = eventIds;
    }

    public ObservableListWrapperA<Integer> getIssueIds() {
        return issueIds;
    }

    public void setIssueIds(ObservableListWrapperA<Integer> issueIds) {
        this.issueIds = issueIds;
    }

    public ObservableListWrapperA<Integer> getObservationIds() {
        return observationIds;
    }

    public void setObservationIds(ObservableListWrapperA<Integer> observationIds) {
        this.observationIds = observationIds;
    }

    public ObservableListWrapperA<Integer> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(ObservableListWrapperA<Integer> taskIds) {
        this.taskIds = taskIds;
    }

}
