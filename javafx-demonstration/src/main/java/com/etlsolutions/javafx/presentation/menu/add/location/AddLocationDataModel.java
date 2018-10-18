package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddLocationDataModel extends DataUnitFXMLDataModel {

    public static final String AREA_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.location.AddLocationDataModel.AREA_PROPERTY";
    public static final String SUBAREA_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.location.AddLocationDataModel.SUBAREA_PROPERTY";
    public static final String LOCATION_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.location.AddLocationDataModel.LOCATION_TYPE_PROPERTY";
    
    public static final RemoveEventId SELECTED_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.location.AddLocationDataModel", "selected area");
    
    private final ObservableList<Area> areas;
    private Area selectedArea;
    private ObservableList<SubArea> subAreas;
    private SubArea selectedSubArea;
    private ObservableList<LocationType> types;
    private LocationType selectedType;

    public AddLocationDataModel() {
        areas = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas());
        selectedArea = areas.get(0);
        subAreas = new ObservableListWrapperA<>(selectedArea.getAllSubAreas());
        selectedSubArea = subAreas.get(0);
        types = selectedSubArea == null ? new ObservableListWrapperA<LocationType>() : new ObservableListWrapperA<>(selectedSubArea.getType().getLocationTypes());
        selectedType = types.get(0);
    }

    public ObservableList<Area> getAreas() {
        return areas;
    }

    public void addArea(Area area) {
        ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas().add(area);
        areas.add(area);
        setSelectedArea(area);
    }
    
    
    public Area getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Area selectedArea) {

        Area oldValue = this.selectedArea;
        this.selectedArea = selectedArea;
        subAreas = this.selectedArea.getAllSubAreas();
        setSelectedSubArea(subAreas.isEmpty() ? null : subAreas.get(0));
        support.firePropertyChange(AREA_PROPERTY, oldValue, this.selectedArea);
    }

    public ObservableList<SubArea> getSubAreas() {
        return subAreas;
    }

    public SubArea getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {
        SubArea oldValue = this.selectedSubArea;
        this.selectedSubArea = selectedSubArea;
        types = this.selectedSubArea == null ? new ObservableListWrapperA<LocationType>() : new ObservableListWrapperA<>(selectedSubArea.getType().getLocationTypes());
        selectedType = types.isEmpty() ? null : types.get(0);
        support.firePropertyChange(SUBAREA_PROPERTY, oldValue, this.selectedSubArea);
    }

    public ObservableList<LocationType> getTypes() {
        return types;
    }

    public LocationType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(LocationType selectedType) {
        LocationType oldValue = this.selectedType;
        this.selectedType = selectedType;
        support.firePropertyChange(LOCATION_TYPE_PROPERTY, oldValue, this.selectedType);
    }

    public String getGroudLocationDeatailsFxmlPath() {

        return "/fxml/menu/add/location/GroundLocationDetailFXML.fxml";
    }

    public String getContainerFxmlPath() {
        return "/fxml/menu/add/location/ContainerDetailFXML.fxml";
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(RemoveEventId id) {
        super.remove(id); 
    }



    
    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGventFXML.fxml";
    }

    @Override
    protected void validate() {
        
        if(selectedType == null) {
            valid = false;
            errorMessage = "Create an area part for the location.";
        }
        
        super.validate();
    }
    
}
