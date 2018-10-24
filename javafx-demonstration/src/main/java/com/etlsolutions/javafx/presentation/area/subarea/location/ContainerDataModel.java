package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurement;
import com.etlsolutions.javafx.presentation.area.subarea.HeightDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.VolumeDataModel;

/**
 *
 * @author zc
 */
public class ContainerDataModel extends LocationMeasurementDataModel<ContainterMeasurement> implements HeightDataModel, VolumeDataModel {

    public ContainerDataModel(ContainterMeasurement measurement) {
        super(measurement);
    }

    public String getShape() {
        return measurement.getShape();
    }

    public void setShape(String title) {
        measurement.setShape(title);
    }

    @Override
    public String getHeight() {
        return measurement.getHeight();
    }

    @Override
    public void setHeight(String height) {
        measurement.setHeight(height);
    }

    @Override
    public String getVolume() {
        return measurement.getVolume();
    }

    @Override
    public void setVolume(String volume) {
        measurement.setVolume(volume);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/ContainerFXML.fxml";
    }
}
