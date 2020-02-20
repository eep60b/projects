package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.DataUnitPart;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.gvent.FruitingGvent;
import com.etlsolutions.javafx.data.log.gvent.FloweringGvent;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GrowingDetail extends DataUnitPart {

    @JsonIgnore
    public static final String IS_ALIVE_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.IS_ALIVE_PROPERTY";

    @JsonIgnore
    public static final String GROWING_START_POINT_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.GROWING_START_POINT_PROPERTY";
    
    @JsonIgnore
    public static final String GROWING_TERMINATION_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.GROWING_TERMINATION_PROPERTY";

    @JsonIgnore
    public static final String GROWING_MEDIUM_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.GROWING_MEDIUM_PROPERTY";

    @JsonIgnore
    public static final String TRANSPLANT_TASKS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.TRANSPLANT_TASKS_PROPERTY";

    @JsonIgnore
    public static final String PLANT_TINNING_TASKS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.PLANT_TINNING_TASKS_PROPERTY";

    @JsonIgnore
    public static final String WATERING_TASKS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.WATERING_TASKS_PROPERTY";

    @JsonIgnore
    public static final String FERTILISATION_TASKS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.FERTILISATION_TASKS_PROPERTY";

    @JsonIgnore
    public static final String FLOWERING_EVENTS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.FLOWERING_EVENTS_PROPERTY";

    @JsonIgnore
    public static final String FRUITING_EVENTS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.FRUITING_EVENTS_PROPERTY";

    @JsonIgnore
    public static final String HAVESTING_TASKS_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.HAVESTING_TASKS_PROPERTY";

    @JsonIgnore
    public static final String GROWING_ISSUES_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.GROWING_ISSUES_PROPERTY";

    @JsonIgnore
    public static final String GROWING_OBSERVATION_PROPERTY = "com.etlsolutions.javafx.data.plant.GrowingDetail.GROWING_OBSERVATION_PROPERTY";
    
    private boolean isAlive;
    private GrowingStartPoint startPoint;
    private GrowingTermination growingTermination;
    private GrowingMedium growingMedium;
    private List<TransplantTask> transplantTasks;
    private List<PlantThinningTask> plantThinningTasks;
    private List<WateringTask> wateringTasks;
    private List<FertilisationTask> fertilisationTasks;
    private List<FloweringGvent> floweringEvents;
    private List<FruitingGvent> fruitingEvents;
    private List<HarvestingTask> harvestingTasks;
    private List<GrowingIssue> growingIssues;
    private List<GrowingObservation> growingObservations;
    private ObservableListWrapperA<Location> locations;

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        boolean oldValue = this.isAlive;
        this.isAlive = isAlive;
        fireChange(IS_ALIVE_PROPERTY, oldValue, this.isAlive);
    }

    public GrowingStartPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(GrowingStartPoint startPoint) {
        GrowingStartPoint oldValue = this.startPoint;
        this.startPoint = startPoint;
        fireChange(GROWING_START_POINT_PROPERTY, oldValue, this.startPoint);
    }

    public GrowingTermination getGrowingTermination() {
        return growingTermination;
    }

    public void setGrowingTermination(GrowingTermination growingTermination) {
        GrowingTermination oldValue = this.growingTermination;
        this.growingTermination = growingTermination;
        fireChange(GROWING_TERMINATION_PROPERTY, oldValue, this.growingTermination);
    }

    public GrowingMedium getGrowingMedium() {
        return growingMedium;
    }

    public void setGrowingMedium(GrowingMedium growingMedium) {
        GrowingMedium oldValue = this.growingMedium;
        this.growingMedium = growingMedium;
        fireChange(GROWING_MEDIUM_PROPERTY, oldValue, this.growingMedium);
    }

    public List<TransplantTask> getTransplantTasks() {
        return new ArrayList<>(transplantTasks);
    }

    public void setTransplantTasks(List<TransplantTask> transplantTasks) {
        this.transplantTasks = new ArrayList<>(transplantTasks);
        fireChange(TRANSPLANT_TASKS_PROPERTY);
    }
    
    public boolean addTransplantTask(TransplantTask task) {
        boolean added = transplantTasks.add(task);
        fireChange(TRANSPLANT_TASKS_PROPERTY, false, added);
        return added;
    }
    
    public boolean removeTransplantTask(TransplantTask task) {
        boolean removed = transplantTasks.remove(task);
        fireChange(TRANSPLANT_TASKS_PROPERTY, false, removed);
        return removed;
    }
    
    public List<PlantThinningTask> getPlantThinningTasks() {
        return new ArrayList<>(plantThinningTasks);
    }

    public void setPlantThinningTasks(List<PlantThinningTask> plantThinningTasks) {
        this.plantThinningTasks = new ArrayList<>(plantThinningTasks);
        fireChange(PLANT_TINNING_TASKS_PROPERTY);
    }
    
    public boolean addPlantThinning(PlantThinningTask plantThinningTask) {
        boolean added = plantThinningTasks.add(plantThinningTask);
        fireChange(PLANT_TINNING_TASKS_PROPERTY, false, added);
        return added;
    }    
    
    public boolean removePlantThinning(PlantThinningTask plantThinningTask) {
        boolean removed = plantThinningTasks.remove(plantThinningTask);
        fireChange(PLANT_TINNING_TASKS_PROPERTY, false, removed);
        return removed;
    }    

    public List<WateringTask> getWateringTasks() {
        return new ArrayList<>();
    }

    public void setWateringTasks(List<WateringTask> wateringTasks) {
        this.wateringTasks = new ArrayList<>(wateringTasks);
        fireChange(WATERING_TASKS_PROPERTY);
    }
 
    public boolean addWateringTask(WateringTask wateringTask) {
        boolean added = wateringTasks.add(wateringTask);
        fireChange(WATERING_TASKS_PROPERTY, false, added);
        return added;
    }   
 
    public boolean removeWateringTask(WateringTask wateringTask) {
        boolean removed = wateringTasks.remove(wateringTask);
        fireChange(WATERING_TASKS_PROPERTY, false, removed);
        return removed;
    }  
    
    public List<FertilisationTask> getFertilisationTasks() {
        return new ArrayList<>(fertilisationTasks);
    }

    public void setFertilisationTasks(List<FertilisationTask> fertilisationTasks) {
        this.fertilisationTasks = new ArrayList<>(fertilisationTasks);
        fireChange(FERTILISATION_TASKS_PROPERTY);
    }

    public boolean addFertilisationTask(FertilisationTask fertilisationTask) {
        boolean added = fertilisationTasks.add(fertilisationTask);
        fireChange(FERTILISATION_TASKS_PROPERTY, false, added);
        return added;
    }

    public boolean removeFertilisationTask(FertilisationTask fertilisationTask) {
        boolean removed = fertilisationTasks.remove(fertilisationTask);
        fireChange(FERTILISATION_TASKS_PROPERTY, false, removed);
        return removed;
    }
    
    public List<FloweringGvent> getFloweringEvents() {
        return new ArrayList<>(floweringEvents);
    }

    public void setFloweringEvents(List<FloweringGvent> floweringEvents) {
        this.floweringEvents = new ArrayList<>(floweringEvents);
        fireChange(FLOWERING_EVENTS_PROPERTY);
    }

    public boolean addFloweringTask(FloweringGvent floweringTask) {
        boolean added = floweringEvents.add(floweringTask);
        fireChange(FLOWERING_EVENTS_PROPERTY, false, added);
        return added;
    }

    public boolean removeFloweringTask(FloweringGvent floweringTask) {
        boolean removed = floweringEvents.remove(floweringTask);
        fireChange(FLOWERING_EVENTS_PROPERTY, false, removed);
        return removed;
    }
    
    public List<FruitingGvent> getFruitingEvents() {
        return new ArrayList<>(fruitingEvents);
    }

    public void setFruitingEvents(List<FruitingGvent> fruitingEvents) {
        this.fruitingEvents = new ArrayList<>(fruitingEvents);
        fireChange(FRUITING_EVENTS_PROPERTY);
    }

    public boolean addFruitingEvent(FruitingGvent fruitingEvent) {
        boolean added = fruitingEvents.add(fruitingEvent);
        fireChange(FRUITING_EVENTS_PROPERTY, false, added);
        return added;
    }
 
    public boolean removeFruitingEvent(FruitingGvent fruitingEvent) {
        boolean removed = fruitingEvents.remove(fruitingEvent);
        fireChange(FRUITING_EVENTS_PROPERTY, false, removed);
        return removed;
    }
    
    public List<HarvestingTask> getHarvestingTasks() {
        return new ArrayList<>(harvestingTasks);
    }

    public void setHarvestingTasks(List<HarvestingTask> harvestingTasks) {
        this.harvestingTasks = new ArrayList<>(harvestingTasks);
        fireChange(HAVESTING_TASKS_PROPERTY);
    }

    public boolean addHarvestingTask(HarvestingTask harvestingTask) {
        boolean added = harvestingTasks.add(harvestingTask);
        fireChange(HAVESTING_TASKS_PROPERTY, false, added);
        return added;
    }

    public boolean removeHarvestingTask(HarvestingTask harvestingTask) {
        boolean removed = harvestingTasks.remove(harvestingTask);
        fireChange(HAVESTING_TASKS_PROPERTY, false, removed);
        return removed;
    }
    
    public List<GrowingIssue> getGrowingIssues() {
        return new ArrayList<>(growingIssues);
    }

    public void setGrowingIssues(List<GrowingIssue> growingIssues) {
        this.growingIssues = new ArrayList<>(growingIssues);
        fireChange(GROWING_ISSUES_PROPERTY);
    }

    public boolean addGrowingIssue(GrowingIssue growingIssue) {
        boolean added = growingIssues.add(growingIssue);
        fireChange(GROWING_ISSUES_PROPERTY, false, added);
        return added;
    }

    public boolean removeGrowingIssue(GrowingIssue growingIssue) {
        boolean removed = growingIssues.remove(growingIssue);
        fireChange(GROWING_ISSUES_PROPERTY, false, removed);
        return removed;
    }
    
    public List<GrowingObservation> getGrowingObservations() {
        return new ArrayList<>(growingObservations);
    }

    public void setGrowingObservations(List<GrowingObservation> growingObservations) {
        this.growingObservations = new ArrayList<>(growingObservations);
        fireChange(GROWING_OBSERVATION_PROPERTY);
    }

    public boolean addGrowingObservation(GrowingObservation growingObservation) {
        boolean added = growingObservations.add(growingObservation);
        fireChange(GROWING_OBSERVATION_PROPERTY, false, added);
        return added;
    }

    public boolean removeGrowingObservation(GrowingObservation growingObservation) {
        boolean removed = growingObservations.remove(growingObservation);
        fireChange(GROWING_OBSERVATION_PROPERTY, false, removed);
        return removed;
    }    
}
