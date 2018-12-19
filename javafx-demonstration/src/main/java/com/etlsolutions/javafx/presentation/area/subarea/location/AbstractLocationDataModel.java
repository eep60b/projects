package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModelGenerator;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public abstract class AbstractLocationDataModel extends DataUnitFXMLDataModel<Location> implements FXMLContentActionDataModel<LocationMeasurementDataModel> {

    public static final RemoveEventId REMOVE_AREA_EVENT_ID = new RemoveEventId(AbstractLocationDataModel.class.getName() + "REMOVE_AREA_EVENT_ID", "area");
    public static final RemoveEventId REMOVE_SUBAREA_EVENT_ID = new RemoveEventId(AbstractLocationDataModel.class.getName() + "REMOVE_SUBAREA_EVENT_ID", "area part");

    private final ObservableListWrapperA<Area> areas;
    protected ValueWrapper<Area> selectedAreaValueWrapper;
    private final ObservableListWrapperA<SubArea> subAreas;
    protected ValueWrapper<SubArea> selectedSubAreaValueWrapper;
    private final ObservableListWrapperA<LocationType> types;
    protected final LocationValueWrapper locationValueWrapper;
    protected LocationMeasurementDataModel measurementDataModel;

    public AbstractLocationDataModel(int plantId) {
        areas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAreas());
        selectedAreaValueWrapper = new ValueWrapper<>(this.areas.get(0));
        subAreas = selectedAreaValueWrapper.getValue().getSubAreas();
        selectedSubAreaValueWrapper = new ValueWrapper<>(subAreas.isEmpty() ? null : subAreas.get(0));
        types = selectedSubAreaValueWrapper.getValue() == null ? new ObservableListWrapperA<LocationType>() : selectedSubAreaValueWrapper.getValue().getLocationTypes();
        locationValueWrapper = selectedSubAreaValueWrapper.getValue() == null ? (types.isEmpty() ? new LocationValueWrapper() : new LocationValueWrapper(types.get(0), 0, plantId)) : new LocationValueWrapper(types.get(0), selectedSubAreaValueWrapper.getValue().getId(), plantId);
        measurementDataModel = MeasurementDataModelGenerator.getInstance().getMeasurementDataModel(locationValueWrapper.getTypeValueWrapper().getValue().getMeasurementType());
    }

    public AbstractLocationDataModel(Area area, SubArea subArea, Location location) {
        super(location);
        areas = new ObservableListWrapperA<>(area);
        selectedAreaValueWrapper = new ValueWrapper<>(area);
        subAreas = new ObservableListWrapperA<>(subArea);
        selectedSubAreaValueWrapper = new ValueWrapper<>(subArea);
        locationValueWrapper = new LocationValueWrapper(location);
        types = new ObservableListWrapperA<>(location.getType());
        measurementDataModel = MeasurementDataModelGenerator.getInstance().getMeasurementDataModel(locationValueWrapper.getTypeValueWrapper().getValue().getMeasurementType());
    }

    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }

    public ValueWrapper<Area> getSelectedAreaValueWrapper() {
        return selectedAreaValueWrapper;
    }

    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public ValueWrapper<SubArea> getSelectedSubAreaValueWrapper() {
        return selectedSubAreaValueWrapper;
    }

    public ObservableListWrapperA<LocationType> getTypes() {
        return types;
    }

    @Override
    public LocationMeasurementDataModel getContentModel() {
        return measurementDataModel;
    }

    @Override
    public void setContentModel(LocationMeasurementDataModel model) {
        this.measurementDataModel = model;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/LocationFXML.fxml";
    }

    public LocationValueWrapper getLocationValueWrapper() {
        return locationValueWrapper;
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

    @Override
    public void remove(RemoveEventId id) {

        if (id == REMOVE_AREA_EVENT_ID) {
            areas.removeAndGetNext(selectedAreaValueWrapper);
        }
        if (id == REMOVE_SUBAREA_EVENT_ID) {
            subAreas.removeAndGetNext(selectedSubAreaValueWrapper);
        }

        super.remove(id);
    }
}
