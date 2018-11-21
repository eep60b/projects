package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class BoxDataModel extends MeasurementDataModel<RectangleMeasurementValueWrapper> {

    private final String title;

    public BoxDataModel(String title, RectangleMeasurement measurement) {
        super(new RectangleMeasurementValueWrapper(measurement));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ValueWrapper<String> getLengthValueWrapper() {
        return measurementValueWrapper.getLengthValueWrapper();
    }

    public ValueWrapper<String> getWidthValueWrapper() {
        return measurementValueWrapper.getWidthValueWrapper();
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return measurementValueWrapper.getHeightValueWrapper();
    }

    public String getAreaString() {
        return measurementValueWrapper.getAreaString();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/BoxFXML.fxml";
    }

}
