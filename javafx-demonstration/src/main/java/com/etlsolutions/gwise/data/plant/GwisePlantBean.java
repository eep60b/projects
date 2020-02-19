package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.other.GwiseGrowingMedium;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantBean extends GwiseDataUnitBean {

    private int plantsId;
    private int locationId;
    private boolean isAlive;
    private GrowingStartPoint growingStartPoint;
    private LocalDateTime startTime;
    private int growingMediumId;
    private int plantVarietyId;
    private String terminationReason; //Harvested. destroied by disease, insecte, cold weather, hot weather, droupht, tater log, high wind, over-fertiliser.
    private LocalDateTime terminationTime;
    private List<Gvent> gvents;
    private List<GrowingIssue> growingIssues;
    private List<GrowingObservation> growingObservations;
    private List<Task> tasks;       
    
    public GwisePlantBean() {
    }

    public GwisePlantBean(GwisePlant plant) {
        super(plant);
        plantsId = plant.getPlants().getId();
        locationId = plant.getLocationValueWrapper().getValue().getId();
    }

    public int getPlantsId() {
        return plantsId;
    }

    public void setPlantsId(int plantsId) {
        this.plantsId = plantsId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public GrowingStartPoint getGrowingStartPoint() {
        return growingStartPoint;
    }

    public void setGrowingStartPoint(GrowingStartPoint growingStartPoint) {
        this.growingStartPoint = growingStartPoint;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
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

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public LocalDateTime getTerminationTime() {
        return terminationTime;
    }

    public void setTerminationTime(LocalDateTime terminationTime) {
        this.terminationTime = terminationTime;
    }

    public List<Gvent> getGvents() {
        return gvents;
    }

    public void setGvents(List<Gvent> gvents) {
        this.gvents = gvents;
    }

    public List<GrowingIssue> getGrowingIssues() {
        return growingIssues;
    }

    public void setGrowingIssues(List<GrowingIssue> growingIssues) {
        this.growingIssues = growingIssues;
    }

    public List<GrowingObservation> getGrowingObservations() {
        return growingObservations;
    }

    public void setGrowingObservations(List<GrowingObservation> growingObservations) {
        this.growingObservations = growingObservations;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }    
}
