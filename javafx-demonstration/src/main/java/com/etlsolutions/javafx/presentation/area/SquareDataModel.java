package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class SquareDataModel extends MeasurementDataModel<SquareMeasurementValueWrapper> {

    public SquareDataModel(SquareMeasurement measurement) {
        super(new SquareMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<String> getSideValueWrapper() {
        return measurementValueWrapper.getSideValueWrapper();
    }

    public String getAreaString() {
        return measurementValueWrapper.getAreaString();
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return measurementValueWrapper.getHeightValueWrapper();
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/SquareFXML.fxml";
    }
}
