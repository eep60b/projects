package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.dialog.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class BorderMeasurementDataModel extends MeasurementDataModel<BorderMeasurementValueWrapper> {

    public BorderMeasurementDataModel(BorderMeasurement measurement) {
        super(new BorderMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<String> getLengthValueWrapper() {
        return measurementValueWrapper.getLengthValueWrapper();
    }

    public ValueWrapper<String> getWidthValueWrapper() {
        return measurementValueWrapper.getWidthValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/LengthWidthFXML.fxml";
    }
    
}
