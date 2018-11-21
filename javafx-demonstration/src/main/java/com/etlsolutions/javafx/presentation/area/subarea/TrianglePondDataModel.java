package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class TrianglePondDataModel extends MeasurementDataModel<TriangleMeasurementValueWrapper> {

    private final String title;

    public TrianglePondDataModel(String title, TriangleMeasurement measurement) {
        super(new TriangleMeasurementValueWrapper(measurement));
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public ValueWrapper<String> getHeightValueWrapper() {
        return measurementValueWrapper.getHeightValueWrapper();
    }

    public String getArea() {
        return measurementValueWrapper.getAreaString();
    }

    @Override
    public String getFxmlPath() {

        return "/fxml/area/TrianglePondFXML.fxml";
    }
}
