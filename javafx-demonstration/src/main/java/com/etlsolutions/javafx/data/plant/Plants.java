package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private ObservableListWrapperA<Integer> gventIds;
    private ObservableListWrapperA<Integer> growingIssueIds;
    private ObservableListWrapperA<Integer> growingObservationIds;
    private ObservableListWrapperA<Integer> taskIds;

    public Plants() {
    }

    public Plants(PlantValueWrapper plantValueWrapper) {
        super(plantValueWrapper);
        plantSubGroupId = plantValueWrapper.getPlantSubGroupValueWrapper().getValue().getId();
        Location location = plantValueWrapper.getLocationValueWrapper().getValue();
        locationId = location == null ? 0 : location.getId();
        alive = plantValueWrapper.getIsAliveValueWrapper().getValue();
        growingStartPoint = plantValueWrapper.getGrowingStartPointValueWrapper().getValue();        
        startTime = plantValueWrapper.getStartTime();
        GrowingMedium medium = plantValueWrapper.getGrowingMediumValueWrapper().getValue();
        growingMediumId = medium == null ? 0 : medium.getId();
        PlantVariety variety = plantValueWrapper.getPlantVarietyValueWrapper().getValue();
        plantVarietyId = variety == null ? 0 : variety.getId();
        quantity = plantValueWrapper.getQuantityValueWrapper().getValue();
        quantityType = plantValueWrapper.getQuantityTypeValueWrapper().getValue();
        terminationReason = plantValueWrapper.getTerminationReasonValueWrapper().getValue();
        terminationTime = plantValueWrapper.getTerminationTime();
        gventIds = plantValueWrapper.getGventIds();
        growingIssueIds = plantValueWrapper.getGrowingIssueIds();
        growingObservationIds = plantValueWrapper.getGrowingObservationIds();
        taskIds = plantValueWrapper.getTaskIds();
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

    public ObservableListWrapperA<Integer> getGventIds() {
        return gventIds;
    }

    public void setGventIds(ObservableListWrapperA<Integer> gventIds) {
        this.gventIds = gventIds;
    }

    public ObservableListWrapperA<Integer> getGrowingIssueIds() {
        return growingIssueIds;
    }

    public void setGrowingIssueIds(ObservableListWrapperA<Integer> growingIssueIds) {
        this.growingIssueIds = growingIssueIds;
    }

    public ObservableListWrapperA<Integer> getGrowingObservationIds() {
        return growingObservationIds;
    }

    public void setGrowingObservationIds(ObservableListWrapperA<Integer> growingObservationIds) {
        this.growingObservationIds = growingObservationIds;
    }

    public ObservableListWrapperA<Integer> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(ObservableListWrapperA<Integer> taskIds) {
        this.taskIds = taskIds;
    }

    public void setValues(PlantValueWrapper valueWrapper) {
        setCommonValues(valueWrapper);
        setAlive(valueWrapper.getIsAliveValueWrapper().getValue());
        setGrowingIssueIds(valueWrapper.getGrowingIssueIds());
        setGrowingMediumId(valueWrapper.getGrowingMediumValueWrapper().getValue().getId());
        setGrowingObservationIds(valueWrapper.getGrowingObservationIds());
        setGrowingStartPoint(valueWrapper.getGrowingStartPointValueWrapper().getValue());
        setGventIds(valueWrapper.getGventIds());
        setLocationId(valueWrapper.getLocationValueWrapper().getValue().getId());
        setPlantVarietyId(valueWrapper.getPlantVarietyValueWrapper().getValue().getId());
        setQuantity(valueWrapper.getQuantityValueWrapper().getValue());
        setQuantityType(valueWrapper.getQuantityTypeValueWrapper().getValue());
        setStartTime(valueWrapper.getStartTime());
        setTaskIds(valueWrapper.getTaskIds());
        setTerminationReason(valueWrapper.getTerminationReasonValueWrapper().getValue());
        setTerminationTime(valueWrapper.getTerminationTime());
    }    
    
}
