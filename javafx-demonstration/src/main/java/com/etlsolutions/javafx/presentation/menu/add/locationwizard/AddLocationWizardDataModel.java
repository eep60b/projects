package com.etlsolutions.javafx.presentation.menu.add.locationwizard;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.wizard.StatusPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.wizard.WizardDataModel;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddLocationWizardDataModel extends DataUnitFXMLDataModel implements WizardDataModel {

    private int currentIndex;
    private final ObservableList<Area> areas;
    private Area selectedArea;
    private ObservableList<SubAreaType> subAreaTypes;
    private SubAreaType selectedSubAreaType;
    private ObservableList<SubArea> subAreas;
    private SubArea selectedSubArea;

    public AddLocationWizardDataModel() {
        areas = ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas();
        selectedArea = areas.get(0);
    //    this.subAreaTypes = selectedArea.getSubAreaTypes();
        selectedSubAreaType = subAreaTypes.get(0);
        subAreas = selectedArea.getSubAreas(selectedSubAreaType);
    }

    public ObservableList<Area> getAreas() {
        return areas;
    }

    public Area getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Area selectedArea) {
        this.selectedArea = selectedArea;
   //     subAreaTypes = this.selectedArea.getSubAreaTypes();
        if (subAreaTypes.contains(selectedSubAreaType)) {
            return;
        }
        setSelectedSubAreaType(subAreaTypes.get(0));
    }

    public ObservableList<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(ObservableList<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public SubArea getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {
        SubArea oldValue = this.selectedSubArea;
        this.selectedSubArea = selectedSubArea;
        support.firePropertyChange(STATUS_PROPERTY, oldValue, this.selectedSubArea);
    }

    public ObservableList<SubAreaType> getSubAreaTypes() {
        return subAreaTypes;
    }

    public SubAreaType getSelectedSubAreaType() {
        return selectedSubAreaType;
    }

    public void setSelectedSubAreaType(SubAreaType selectedSubAreaType) {
        
        this.selectedSubAreaType = selectedSubAreaType;
        subAreas = selectedArea.getSubAreas(this.selectedSubAreaType);
        if (subAreas.contains(selectedSubArea)) {
            return;
        }
        setSelectedSubArea(this.subAreas.isEmpty() ? null : subAreas.get(0));
    }

    public Location getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getWizardTitle() {
        return "Add Location";
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean notToPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPropertyChangeListener(String NAVIGATE_TO_PREVIOUS_PROPERTY, StatusPropertyChangeAdapter navigateToPreviousPropertyChangeAdapter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean notToNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canNotFinish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentIndex(int newPageIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }

    @Override
    public String getErrorMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
