package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.dialog.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class CirclePondDataModel extends MeasurementDataModel<CircleMeasurementValueWrapper> {

    private final String title;

    public CirclePondDataModel(String title, CircleMeasurement measurement) {
        super(new CircleMeasurementValueWrapper(measurement));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ValueWrapper<String> getDiameterValueWrapper() {
        return measurementValueWrapper.getDiameterValueWrapper();
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return measurementValueWrapper.getHeightValueWrapper();
    }

    public String getAreaString() {
        return measurementValueWrapper.getAreaString();
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/CirclePondFXML.fxml";
    }
    
}
