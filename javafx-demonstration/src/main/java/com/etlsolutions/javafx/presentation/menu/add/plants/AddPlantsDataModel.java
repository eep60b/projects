package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.event.Event;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import com.etlsolutions.javafx.data.plant.PlantsType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zc
 */
public class AddPlantsDataModel {

    private String title;
    private Date datePlanted = new Date();
    private PlantsType type;
    private PlantVariety variety;
    private PlantsQuantity quantity;
    private int plantNumber;
    private String informaton = "";
    private List<ImageLink> imgLinks;
    private int selectedImgLinkIndex;
    private Date plantedDate;
    private GrowingMedium growingMedium;
    private Location location;
    private boolean isAlive = true;
    private Date terminationDate;
    private String terminationReason;
    private List<Event> events = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<GrowingIssue> issues = new ArrayList<>();
    private List<GrowingObservation> observations = new ArrayList<>();

    private boolean valid;
    private String errorMessage;
    
    private void validate() {
        
        if(title == null || title.trim().isEmpty()) {
            errorMessage = "Title is not specified.";
        }
        
        valid = errorMessage.isEmpty();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        validate();
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public PlantsType getType() {
        return type;
    }

    public void setType(PlantsType type) {
        this.type = type;
    }

    public PlantVariety getVariety() {
        return variety;
    }

    public void setVariety(PlantVariety variety) {
        this.variety = variety;
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

    public String getInformaton() {
        return informaton;
    }

    public void setInformaton(String informaton) {
        this.informaton = informaton;
    }

    public List<ImageLink> getImgLinks() {
        return imgLinks;
    }

    public void setImgLinks(List<ImageLink> imgLinks) {
        this.imgLinks = imgLinks;
    }

    public int getSelectedImgLinkIndex() {
        return selectedImgLinkIndex;
    }

    public void setSelectedImgLinkIndex(int selectedImgLinkIndex) {
        this.selectedImgLinkIndex = selectedImgLinkIndex;
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
    
    
}
