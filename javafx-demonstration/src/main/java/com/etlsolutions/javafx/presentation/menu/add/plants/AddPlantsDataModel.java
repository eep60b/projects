package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.GrowingMedium;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.plant.GroupSelectable;
import com.etlsolutions.javafx.system.ProjectConfiguration;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddPlantsDataModel extends DataUnitFXMLDataModel implements GroupSelectable {

    public static final String SELECTED_PLANT_GROUP_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_PLANT_GROUP_PROPERTY ";    
    public static final String PLANT_TYPES_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.PLANT_TYPES_PROPERTY";    
    public static final String SELECTED_PLANT_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_PLANT_TYPE_PROPERTY";    
    public static final String PLANT_VARIETIES_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.PLANT_VARIETIES";   
    public static final String SELECTED_PLANT_VARIETY_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_PLANT_VARIETY_PROPERTY"; 
    public static final String QUANTITY_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.QUANTITY_TYPE_PROPERTY";
    public static final String SELECTED_GROWING_MEDIUM_RPOPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.SELECTED_GROWING_MEDIUM_RPOPERTY";
    public static final String LOCATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.LOCATION_PROPERTY";
    public static final String ALIVE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plants.DataUnitDataModel.ALIVE_PROPERTY";

    private final ObservableList<PlantGroup> plantGroups;
    private final ObservableList<GrowingMedium> growingMediums;
    private PlantGroup selectedPlantGroup;
    private GrowingMedium selectedGrowingMedium;    
    private final ObservableListWrapperA<PlantType> plantTypes;    
    private PlantType selectedPlantType;
    private ObservableList<PlantVariety> plantVarieties;
    private PlantVariety selectedVariety;
    private final PlantsQuantity quantity;
    private LocalDateTime plantedDate;
    private Location location;
    private boolean alive;
    private LocalDateTime terminationDate;
    private String terminationReason;
    private final ObservableList<Gvent> events;
    private Gvent selectedEvent;
    private final ObservableList<Task> tasks;
    private Task selectedTask;
    private final ObservableList<GrowingIssue> issues;
    private GrowingIssue selectedGrowingIssue;
    private final ObservableList<GrowingObservation> observations;
    private GrowingObservation selectedGrowingObservation;

    /**
     * Construct an object.
     *
     * @throws IndexOutOfBoundsException if no plant group can be selected from the plant group list.
     */
    public AddPlantsDataModel() {
        
        ProjectConfiguration project = ProjectManager.getInstance().getProject();
        
        plantGroups = project.getPlantsGroupRoot().getPlantGroups();
        selectedPlantGroup = plantGroups.get(0);        
        growingMediums = project.getGrowingMediums();
        selectedGrowingMedium = growingMediums.get(0);
        plantTypes = new ObservableListWrapperA<>(selectedPlantGroup.getPlantsTypes());
        selectedPlantType = plantTypes.get(0);
        plantVarieties = selectedPlantType.getPlantVarieties();
        if(!plantVarieties.isEmpty()) {
            selectedVariety = plantVarieties.get(0);
        }
        quantity = new PlantsQuantity();
        plantedDate = LocalDateTime.now();
        alive = true;
        terminationDate = LocalDateTime.now();
        terminationReason = "";
        events = FXCollections.observableArrayList();
        tasks = FXCollections.observableArrayList();
        issues = FXCollections.observableArrayList();
        observations = FXCollections.observableArrayList();
    }

    public ObservableList<PlantGroup> getPlantGroups() {
        return plantGroups;
    }

    public PlantGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    @Override
    public void setSelectedPlantGroup(PlantGroup selectedPlantGroup) {

        if (Objects.equals(this.selectedPlantGroup, selectedPlantGroup)) {
            return;
        }

        this.selectedPlantGroup = selectedPlantGroup;
        setPlantTypes(this.selectedPlantGroup.getPlantsTypes());
    }

    public ObservableListWrapperA<PlantType> getPlantTypes() {
        return plantTypes;
    }

    public void setPlantTypes(ObservableList<PlantType> plantTypes) {
        this.plantTypes.clear();
        this.plantTypes.addAll(plantTypes);
        if(!this.plantTypes.isEmpty() && !this.plantTypes.contains(selectedPlantType)) {
            setSelectedPlantType(this.plantTypes.get(0));
        }
    }

    public ObservableList<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    public void setPlantVarieties(ObservableList<PlantVariety> plantVarieties) {
        this.plantVarieties = plantVarieties;
        support.firePropertyChange(PLANT_VARIETIES_PROPERTY);
    }

    public boolean addPlantVariety(PlantVariety variety) {
        boolean added = selectedPlantType.getPlantVarieties().add(variety);
        if(added) {
            setPlantVarieties(selectedPlantType.getPlantVarieties());
            setSelectedVariety(variety);
        }
        
        return added;
    }
      
    public PlantType getSelectedPlantType() {
        return selectedPlantType;
    }

    public void setSelectedPlantType(PlantType selectedPlantType) {
        PlantType oldValue = this.selectedPlantType;        
        this.selectedPlantType = selectedPlantType;
        support.firePropertyChange(SELECTED_PLANT_TYPE_PROPERTY, oldValue, this.selectedPlantType);
        if(selectedPlantType != null) {
            setPlantVarieties(this.selectedPlantType.getPlantVarieties());
        }
    }

    public PlantVariety getSelectedVariety() {
        return selectedVariety;
    }

    public void setSelectedVariety(PlantVariety selectedVariety) {
        PlantVariety oldValue = this.selectedVariety;
        this.selectedVariety = selectedVariety;
        support.firePropertyChange(SELECTED_PLANT_VARIETY_PROPERTY, oldValue, this.selectedVariety);
    }

    public PlantsQuantity.Type getQuantityType() {
        return quantity.getType();
    }

    public void setQuantityType(Type type) {
        PlantsQuantity.Type oldValue = quantity.getType();
        quantity.setType(type);
        support.firePropertyChange(QUANTITY_TYPE_PROPERTY, oldValue, quantity.getType());
    }

    public int getPlantNumber() {
        return quantity.getQuantity();
    }

    public void setPlantNumber(int plantNumber) {        
        quantity.setQuantity(plantNumber);
    }

    public LocalDateTime getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDateTime plantedDate) {
        this.plantedDate = plantedDate;
    }

    public ObservableList<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }
    
    public GrowingMedium getSelectedGrowingMedium() {
        return selectedGrowingMedium;
    }

    public void setSelectedGrowingMedium(GrowingMedium selectedGrowingMedium) {
        this.selectedGrowingMedium = selectedGrowingMedium;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        
        Location oldValue = this.location;
        this.location = location;
        support.firePropertyChange(LOCATION_PROPERTY, oldValue, this.location);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        boolean oldValue = this.alive;
        this.alive = alive;
        support.firePropertyChange(ALIVE_PROPERTY, oldValue, this.alive);        
    }

    public LocalDateTime getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDateTime terminationDate) {
        this.terminationDate = terminationDate;
    }
    
    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public ObservableList<Gvent> getEvents() {
        return events;
    }

    public Gvent getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Gvent selectedEvent) {
        this.selectedEvent = selectedEvent;
    }
    
    public void removeSelectedEvent() {
        events.remove(selectedEvent);
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
        
    public void removeSelectedTask() {
        tasks.remove(selectedTask);
    }
    
    public ObservableList<GrowingIssue> getIssues() {
        return issues;
    }

    public GrowingIssue getSelectedGrowingIssue() {
        return selectedGrowingIssue;
    }

    public void setSelectedGrowingIssue(GrowingIssue selectedGrowingIssue) {
        this.selectedGrowingIssue = selectedGrowingIssue;
    }

    public void removeSelectedGrowingIssue() {
        issues.remove(selectedGrowingIssue);
    }
    
    public ObservableList<GrowingObservation> getObservations() {
        return observations;
    }

    public GrowingObservation getSelectedGrowingObservation() {
        return selectedGrowingObservation;
    }

    public void setSelectedGrowingObservation(GrowingObservation selectedGrowingObservation) {
        this.selectedGrowingObservation = selectedGrowingObservation;
    }

    public void removeSelectedGrowingObservation() {
        observations.remove(selectedGrowingObservation);
    }
    
    @Override
    public void save() {
        selectedPlantType.getPlantsList().add(PlantsFactory.getInstance().creatPlants());
    }

    public void updateLocation() {
        support.firePropertyChange(LOCATION_PROPERTY);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddPlantsFXML.fxml";
    }
}
