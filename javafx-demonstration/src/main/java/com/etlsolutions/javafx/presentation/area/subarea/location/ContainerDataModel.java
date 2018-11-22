package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.area.subarea.HeightDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.VolumeDataModel;

/**
 *
 * @author zc
 */
public class ContainerDataModel extends LocationMeasurementDataModel<ContainterMeasurementValueWrapper> implements HeightDataModel, VolumeDataModel {

    public ContainerDataModel(ContainterMeasurementValueWrapper measurement) {
        super(measurement);
    }

    public String getShape() {
        return String.valueOf(measurement.getShape());
    }

    public void setShape(String title) {
        measurement.getShape().setTitle(title);
    }

    @Override
    public String getHeight() {
        return String.valueOf(measurement.getHeight());
    }

    @Override
    public void setHeight(String height) {
        measurement.setHeight(Double.parseDouble(height));
    }

    @Override
    public String getVolume() {
        return String.valueOf(measurement.getVolume());
    }

    @Override
    public void setVolume(String volume) {
        measurement.setVolume(Double.parseDouble(volume));
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/ContainerFXML.fxml";
    }
}
