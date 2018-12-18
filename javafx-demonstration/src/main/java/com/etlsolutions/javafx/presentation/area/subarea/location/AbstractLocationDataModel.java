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

    private final ObservableListWrapperA<Area> areas;
    protected ValueWrapper<Area> selectedAreaValueWrapper;
    private final ObservableListWrapperA<SubArea> subAreas;
    protected ValueWrapper<SubArea> selectedSubAreaValueWrapper;
    private final ObservableListWrapperA<LocationType> types;
    protected final LocationValueWrapper locationValueWrapper;
    protected ValueWrapper<LocationMeasurementDataModel> measurementDataModelValueWrapper;

    public AbstractLocationDataModel(int plantId) {
        areas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAreas());
        selectedAreaValueWrapper = new ValueWrapper<>(this.areas.get(0));
        subAreas = selectedAreaValueWrapper.getValue().getSubAreas();
        selectedSubAreaValueWrapper = new ValueWrapper<>(subAreas.isEmpty() ? null : subAreas.get(0));
        types = selectedSubAreaValueWrapper.getValue() == null ? new ObservableListWrapperA<LocationType>() : selectedSubAreaValueWrapper.getValue().getLocationTypes();
        locationValueWrapper = selectedSubAreaValueWrapper.getValue() == null ?(types.isEmpty() ? new LocationValueWrapper() : new LocationValueWrapper(types.get(0), 0, plantId)) : new LocationValueWrapper(types.get(0), selectedSubAreaValueWrapper.getValue().getId(), plantId);
        measurementDataModelValueWrapper = new ValueWrapper<>(getMeasurementDataModel(locationValueWrapper.getTypeValueWrapper().getValue().getMeasurementType()));
    }

    public AbstractLocationDataModel(Area area, SubArea subArea, Location location) {
        super(location);
        areas = new ObservableListWrapperA<>(area);
        selectedAreaValueWrapper = new ValueWrapper<>(area);
        subAreas = new ObservableListWrapperA<>(subArea);
        selectedSubAreaValueWrapper = new ValueWrapper<>(subArea);
        locationValueWrapper = new LocationValueWrapper(location);
        types = new ObservableListWrapperA<>(location.getType());
    }

    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }

    public ValueWrapper<Area> getSelectedAreaValueWrapper() {
        return selectedAreaValueWrapper;
    }

    public void setSelectedArea(Area selectedArea) {

        this.selectedAreaValueWrapper = new ValueWrapper<>(selectedArea);
        subAreas.clear();
        subAreas.addAll(this.selectedAreaValueWrapper.getValue().getAllSubAreas());
        setSelectedSubArea(subAreas.isEmpty() ? null : subAreas.get(0));
    }

    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public ValueWrapper<SubArea> getSelectedSubAreaValueWrapper() {
        return selectedSubAreaValueWrapper;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {

        this.selectedSubAreaValueWrapper = new ValueWrapper<>(selectedSubArea);
        types.clear();
        types.addAll(this.selectedSubAreaValueWrapper.getValue().getLocationTypes());
        locationValueWrapper.getTypeValueWrapper().setValue(types.isEmpty() ? null : types.get(0));
    }

    public ObservableListWrapperA<LocationType> getTypes() {
        return types;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/LocationFXML.fxml";
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

    @Override
    public String getErrorMessage() {
        
        if (locationValueWrapper.getTypeValueWrapper().getValue() == null) {
            return "No area part available.";
        }
        return super.getErrorMessage();
    }

    @Override
    public boolean isInvalid() {
        
        if (locationValueWrapper.getTypeValueWrapper().getValue() == null) {
            return true;
        }
        return super.isInvalid();
    }

}
