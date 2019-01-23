package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.ContainterMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class ContainerDataModel extends LocationMeasurementDataModel<ContainterMeasurementValueWrapper> {

    public ContainerDataModel(ContainterMeasurementValueWrapper measurement) {
        super(measurement);
    }

    public ValueWrapper<String> getShapeValueWrapper() {
        return valueWrapper.getShapeValueWrapper();
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return valueWrapper.getHeightValueWrapper();
    }

    public ValueWrapper<String> getVolumeValueWrapper() {
        return valueWrapper.getVolumeValueWrapper();
    }
 
    @Override
    public String getFxmlPath() {
        return "/fxml/area/ContainerFXML.fxml";
    }
}
