package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public abstract class AbstractLocationDataModel extends DataUnitFXMLDataModel {

    public static final String SELECTED_AREA_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_AREA_PROPERTY";
    public static final String SELECTED_SUBAREA_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_SUBAREA_PROPERTY";
    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_TYPE_PROPERTY";

    private final ObservableListWrapperA<Area> areas;
    protected Area selectedArea;
    private final ObservableListWrapperA<SubArea> subAreas;
    protected SubArea selectedSubArea;
    private final ObservableListWrapperA<LocationType> types;
    protected LocationType selectedType;
    protected Location location;
    protected LocationMeasurementDataModel measurementDataModel;

    public AbstractLocationDataModel() {
        areas = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas());
        selectedArea = this.areas.get(0);
        subAreas = selectedArea.getAllSubAreas();
        selectedSubArea = subAreas.isEmpty() ? null : subAreas.get(0);
        types = selectedArea == null ? new ObservableListWrapperA<LocationType>() : selectedSubArea.getLocationTypes();
        selectedType = types.isEmpty() ? null : types.get(0);
    }

    public AbstractLocationDataModel(Area area, SubArea subArea, Location location) {
        areas = new ObservableListWrapperA<>(area);
        selectedArea = area;
        subAreas = new ObservableListWrapperA<>(subArea);
        selectedSubArea = subArea;
        this.location = location;
        selectedType = location.getType();
        types = new ObservableListWrapperA<>(selectedType);
    }

    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }

    public Area getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Area selectedArea) {
        Area oldValue = this.selectedArea;
        this.selectedArea = selectedArea;
        subAreas.clear();
        subAreas.addAll(selectedArea.getAllSubAreas());
        setSelectedSubArea(subAreas.isEmpty() ? null : subAreas.get(0));
        support.firePropertyChange(SELECTED_AREA_PROPERTY, oldValue, this.selectedArea);
    }

    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public SubArea getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {

        SubArea oldValue = this.selectedSubArea;
        this.selectedSubArea = selectedSubArea;
        types.clear();
        types.addAll(this.selectedSubArea.getLocationTypes());
        setSelectedType(types.isEmpty() ? null : types.get(0));
        support.firePropertyChange(SELECTED_SUBAREA_PROPERTY, oldValue, this.selectedSubArea);
    }

    public ObservableListWrapperA<LocationType> getTypes() {
        return types;
    }

    public LocationType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(LocationType selectedType) {
        LocationType oldValue = this.selectedType;
        this.selectedType = selectedType;
        support.firePropertyChange(SELECTED_TYPE_PROPERTY, oldValue, this.selectedType);        
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGventFXML.fxml";
    }

    @Override
    protected void validate() {

        if (selectedType == null) {
            invalid = false;
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
