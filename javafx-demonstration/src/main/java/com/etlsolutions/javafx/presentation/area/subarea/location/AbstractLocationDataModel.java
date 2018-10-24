package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public abstract class AbstractLocationDataModel extends DataUnitFXMLDataModel {
    
    protected final ObservableListWrapperA<Area> areas;
    protected Area selectedArea;
    protected final ObservableListWrapperA<SubArea> subAreas;
    protected Location location;
    private SubArea selectedSubArea;
    private final ObservableListWrapperA<LocationType> types;
    protected LocationType selectedType;
    protected LocationMeasurementDataModel measurementDataModel;
    
    public AbstractLocationDataModel(ObservableListWrapperA<Area> areas, ObservableListWrapperA<SubArea> subAreas, LocationType[] types) {
        this.areas = new ObservableListWrapperA<>(areas);
        this.selectedArea = this.areas.get(0);
        this.subAreas = new ObservableListWrapperA<>(subAreas);
        selectedSubArea = this.subAreas.get(0);
        this.types = new ObservableListWrapperA<>(types);
        selectedType = this.types.get(0);
    }
    
    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }
    
    public Area getSelectedArea() {
        return selectedArea;
    }
    
    public void setSelectedArea(Area selectedArea) {
        this.selectedArea = selectedArea;
    }
    
    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }
    
    public SubArea getSelectedSubArea() {
        return selectedSubArea;
    }
    
    public void setSelectedSubArea(SubArea selectedSubArea) {
        this.selectedSubArea = selectedSubArea;
    }
    
    public ObservableListWrapperA<LocationType> getTypes() {
        return types;
    }
    
    public LocationType getSelectedType() {
        return selectedType;
    }
    
    public void setSelectedType(LocationType selectedType) {
        this.selectedType = selectedType;
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
        
        if (selectedType == null) {
            valid = false;
            errorMessage = "Create an area part for the location.";
        }
        
        super.validate();
    }
    
    public LocationMeasurementDataModel getMeasurementDataModel(LocationMeasurementType type) {
        switch (type) {
            case CONTAINER:
                return new ContainerDataModel(new ContainterMeasurement());
            case GROUND_LOCATION:
                return new GroundLocationMeasurementDataModel(new GroundLocationMeasurement());
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }
    
    public LocationMeasurementDataModel getMeasurementDataModel() {
        return measurementDataModel;
    }
    
}
