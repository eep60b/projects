package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class RectangleDataModel extends MeasurementDataModel<RectangleMeasurementValueWrapper> {

    public RectangleDataModel(RectangleMeasurement measurement) {
        super(new RectangleMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<String> getLengthValueWrapper() {
        return measurementValueWrapper.getLengthValueWrapper();
    }

    public ValueWrapper<String> getWidthValueWrapper() {
        return measurementValueWrapper.getWidthValueWrapper();
    }

    public String getAreaString() {
        return measurementValueWrapper.getAreaString();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/LengthWidthFXML.fxml";
    }

}
