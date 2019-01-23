package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.dialog.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class SquarePondDataModel extends MeasurementDataModel<SquareMeasurementValueWrapper> {

    private final String title;

    public SquarePondDataModel(String title, SquareMeasurement measurement) {
        super(new SquareMeasurementValueWrapper(measurement));
        this.title = title;
    }

    public String getTitle() {
        return title;
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
        return "/fxml/area/SquarePondFXML.fxml";
    }
}
