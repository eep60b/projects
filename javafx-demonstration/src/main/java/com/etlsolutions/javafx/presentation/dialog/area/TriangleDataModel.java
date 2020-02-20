package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class TriangleDataModel extends MeasurementDataModel<TriangleMeasurementValueWrapper> {

    public TriangleDataModel(TriangleMeasurement measurement) {
        super(new TriangleMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<String> getAValueWrapper() {
        return measurementValueWrapper.getAValueWrapper();
    }

    public ValueWrapper<String> getBValueWrapper() {
        return measurementValueWrapper.getBValueWrapper();
    }

    public ValueWrapper<String> getCValueWrapper() {
        return measurementValueWrapper.getCValueWrapper();
    }

    public String getArea() {
        return measurementValueWrapper.getAreaString();
    }

    @Override
    public String getFxmlPath() {

        return "/fxml/area/TriangleFXML.fxml";
    }
}
