package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class CircleDataModel extends MeasurementDataModel<CircleMeasurementValueWrapper> {

    public CircleDataModel(CircleMeasurement measurement) {
        super(new CircleMeasurementValueWrapper(measurement));
    }
    
    public ValueWrapper<String> getDiameterValueWrapper() {
        return measurementValueWrapper.getDiameterValueWrapper();
    }

    public String getAreaString() {
        return measurementValueWrapper.getAreaString();
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/CircleFXML.fxml";
    }
}
