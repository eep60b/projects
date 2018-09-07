package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsGroup;
import com.etlsolutions.javafx.system.ProjectManager;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class AddPlantTypeDialogDataModel {
    
    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.TITLE_PROPERTY";
    
    private String title;
    private String information;
    private List<PlantVariety> varieties;
    private List<ImageLink> imageLinks;
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    private String errorMessage;
    private final List<PlantsGroup> plantGroups = ProjectManager.getInstance().getProject().getPlantsGroupRoot().getPlantsGroups();
    private PlantsGroup selectedPlantGroup = plantGroups.get(0);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldValue = this.title;
        this.title = title;
        validate();
        support.firePropertyChange(TITLE_PROPERTY, oldValue, this.title);
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    private void validate() {
        if(title == null || title.trim().isEmpty()) {
            errorMessage = "Enter the name.";
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean isValid() {
        return errorMessage == null || errorMessage.trim().isEmpty();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }    

    public PlantsGroup getSelectedPlantGroup() {
        return selectedPlantGroup;
    }

    public void setSelectedPlantGroup(PlantsGroup selectedPlantGroup) {
        this.selectedPlantGroup = selectedPlantGroup;
    }



    public List<PlantsGroup> getPlantGroups() {
        return new ArrayList<>(plantGroups);
    }
}