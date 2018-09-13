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
public class PlantTypeDialogDataModel {
    
    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.TITLE_PROPERTY";
    public static final String VARIETIES_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.VARIETIES_PROPERTY";
    public static final String SELECTED_VARIETY_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel.SELECTED_VARIETY_PROPERTY";    
    private String title;
    private String information;
    private List<PlantVariety> varieties;
    private PlantVariety selectedVariety;
    private List<ImageLink> imageLinks;    
    private String errorMessage;
    private final List<PlantsGroup> plantGroups = ProjectManager.getInstance().getProject().getPlantsGroupRoot().getPlantsGroups();
    private PlantsGroup selectedPlantGroup = plantGroups.get(0);
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    
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

    public List<PlantVariety> getVarieties() {
        return new ArrayList<>(varieties);
    }

    public void setVarieties(List<PlantVariety> varieties) {
        this.varieties = new ArrayList<>(varieties);
        support.firePropertyChange(VARIETIES_PROPERTY, false, true);
        if(this.varieties.isEmpty()) {
            setSelectedVariety(null);
        } else {
            setSelectedVariety(this.varieties.get(0));
        }
    }

    public boolean addVariety(PlantVariety variety) {
        boolean added = this.varieties.add(variety);
        support.firePropertyChange(VARIETIES_PROPERTY, false, added);
        
        if(added) {
            setSelectedVariety(variety);
        }
        
        return added;
    }
    
    public PlantVariety getSelectedVariety() {
        return selectedVariety;
    }

    public void setSelectedVariety(PlantVariety selectedVariety) {
        this.selectedVariety = selectedVariety;
    }

    
    
    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<ImageLink> imageLinks) {
        this.imageLinks = imageLinks;
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