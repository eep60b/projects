package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.GroundLocationMeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public abstract class AbstractLocationDataModel extends DataUnitFXMLDataModel<Location> {

    public static final String SELECTED_AREA_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_AREA_PROPERTY";
    public static final String SELECTED_SUBAREA_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_SUBAREA_PROPERTY";
    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.location.AbstractLocationDataModel.SELECTED_TYPE_PROPERTY";

    private final ObservableListWrapperA<Area> areas;
    protected ValueWrapper<Area> selectedArea;
    private final ObservableListWrapperA<SubArea> subAreas;
    protected ValueWrapper<SubArea> selectedSubArea;
    private final ObservableListWrapperA<LocationType> types;
    protected final LocationValueWrapper locationValueWrapper;
    protected ValueWrapper<LocationMeasurementDataModel> measurementDataModelValueWrapper;

    public AbstractLocationDataModel(int plantId) {
        areas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas());
        selectedArea = new ValueWrapper<>(this.areas.get(0));
        subAreas = selectedArea.getValue().getAllSubAreas();
        selectedSubArea = new ValueWrapper<>(subAreas.isEmpty() ? null : subAreas.get(0));
        types = selectedArea.getValue() == null ? new ObservableListWrapperA<LocationType>() : selectedSubArea.getValue().getLocationTypes();
        locationValueWrapper = selectedSubArea.getValue() == null ? new LocationValueWrapper(types.get(0), 0, plantId) : new LocationValueWrapper(types.get(0), selectedSubArea.getValue().getId(), plantId);
        measurementDataModelValueWrapper = new ValueWrapper<>(getMeasurementDataModel(locationValueWrapper.getTypeValueWrapper().getValue().getMeasurementType()));
    }

    public AbstractLocationDataModel(Area area, SubArea subArea, Location location) {
        super(location);
        areas = new ObservableListWrapperA<>(area);
        selectedArea = new ValueWrapper<>(area);
        subAreas = new ObservableListWrapperA<>(subArea);
        selectedSubArea = new ValueWrapper<>(subArea);
        locationValueWrapper = new LocationValueWrapper(location);
        types = new ObservableListWrapperA<>(location.getType());
    }
    
    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }

    public ValueWrapper<Area> getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Area selectedArea) {
        
        this.selectedArea = new ValueWrapper<>(selectedArea);
        subAreas.clear();
        subAreas.addAll(this.selectedArea.getValue().getAllSubAreas());
        setSelectedSubArea(subAreas.isEmpty() ? null : subAreas.get(0));
    }

    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public ValueWrapper<SubArea> getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {
        
        this.selectedSubArea = new ValueWrapper<>(selectedSubArea);
        types.clear();
        types.addAll(this.selectedSubArea.getValue().getLocationTypes());
        locationValueWrapper.getTypeValueWrapper().setValue(types.isEmpty() ? null : types.get(0));
    }

    public ObservableListWrapperA<LocationType> getTypes() {
        return types;
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGventFXML.fxml";
    }

    @Override
    protected void validate() {

        if (locationValueWrapper.getTypeValueWrapper().getValue() == null) {
            invalid = false;
            errorMessage = "Create an area part for the location.";
        }

        super.validate();
    }

    public final LocationMeasurementDataModel getMeasurementDataModel(LocationMeasurementType type) {
        switch (type) {
            case CONTAINER:
                return new ContainerDataModel(new ContainterMeasurementValueWrapper());
            case GROUND_LOCATION:
                return new GroundLocationMeasurementDataModel(new GroundLocationMeasurementValueWrapper());
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public LocationValueWrapper getLocationValueWrapper() {
        return locationValueWrapper;
    }

    public ValueWrapper<LocationMeasurementDataModel> getMeasurementDataModelValueWrapper() {
        return measurementDataModelValueWrapper;
    }
}
