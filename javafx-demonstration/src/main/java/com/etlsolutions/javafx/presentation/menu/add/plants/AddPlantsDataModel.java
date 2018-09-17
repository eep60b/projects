package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.event.Event;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import com.etlsolutions.javafx.data.plant.PlantsType;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.plant.GroupSelectable;
import com.etlsolutions.javafx.system.ProjectManager;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddPlantsDataModel extends DataUnitDataModel implements Savable, Validatable, GroupSelectable {

    public static final String SELECTED_PLANT_GROUP_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_PLANT_GROUP_PROPERTY ";
    public static final String SELECTED_PLANT_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_PLANT_TYPE_PROPERTY";
    
    
    private final ObservableList<PlantGroup> plantGroups;
    private PlantGroup selectedPlantGroup;
    private ObservableList<PlantsType> plantTypes;
    private PlantsType selectedPlantType;
    private ObservableList<PlantVariety> plantVarieties;
    private PlantVariety selectedVariety;
    private PlantsQuantity quantity;
    private int plantNumber;
    private Date plantedDate;
    private GrowingMedium growingMedium;
    private Location location;
    private Date datePlanted = new Date();
    private boolean isAlive = true;
    private Date terminationDate;
    private String terminationReason;
    private List<Event> events = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<GrowingIssue> issues = new ArrayList<>();
    private List<GrowingObservation> observations = new ArrayList<>();

    /**
     * Construct an object.
     *
     * @throws IndexOutOfBoundsException if no plant group can be selected from the plant group list.
     */
    public AddPlantsDataModel() {
        plantGroups = new ObservableListWrapper<>(ProjectManager.getInstance().getProject().getPlantsGroupRoot().getPlantGroups());
        selectedPlantGroup = plantGroups.get(0);
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    public PlantGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    @Override
    public void setSelectedPlantGroup(PlantGroup selectedPlantGroup) {
        
        if(Objects.equals(this.selectedPlantGroup, selectedPlantGroup)) {
            return;
        }
        
        this.selectedPlantGroup = selectedPlantGroup;
        plantTypes = new ObservableListWrapper<>(this.selectedPlantGroup.getPlantsTypes());
        support.firePropertyChange(SELECTED_PLANT_GROUP_PROPERTY);
    }

    public ObservableList<PlantsType> getPlantTypes() {
        return plantTypes;
    }

    public ObservableList<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    
    
    @Override
    public void validate() {
        String title = getTitle();
        if (title == null || title.trim().isEmpty()) {
            errorMessage = "Title is not specified.";
        }

        valid = errorMessage.isEmpty();
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public PlantsType getSelectedPlantType() {
        return selectedPlantType;
    }

    public void setSelectedPlantType(PlantsType selectedPlantType) {
        this.selectedPlantType = selectedPlantType;
    }

    public PlantVariety getSelectedVariety() {
        return selectedVariety;
    }

    public void setSelectedVariety(PlantVariety selectedVariety) {
        this.selectedVariety = selectedVariety;
    }

    public PlantsQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(PlantsQuantity quantity) {
        this.quantity = quantity;
    }

    public int getPlantNumber() {
        return plantNumber;
    }

    public void setPlantNumber(int plantNumber) {
        this.plantNumber = plantNumber;
    }

    public Date getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(Date plantedDate) {
        this.plantedDate = plantedDate;
    }

    public GrowingMedium getGrowingMedium() {
        return growingMedium;
    }

    public void setGrowingMedium(GrowingMedium growingMedium) {
        this.growingMedium = growingMedium;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<GrowingIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<GrowingIssue> issues) {
        this.issues = issues;
    }

    public List<GrowingObservation> getObservations() {
        return observations;
    }

    public void setObservations(List<GrowingObservation> observations) {
        this.observations = observations;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
