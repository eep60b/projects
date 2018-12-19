package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class ContainerSetDataModel extends MeasurementDataModel<ContainerSetMeasurementValueWrapper> {

    public ContainerSetDataModel(ContainerSetMeasurement measurement) {
        super(new ContainerSetMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<Integer> getNumberValueWrapper() {
       return measurementValueWrapper.getNumberValueWrapper();
    }
    
    public ValueWrapper<String> getVolumeValueWrapper(){
        return measurementValueWrapper.getVolumeValueWrapper();
    }
    
    public ValueWrapper<String> getHeightValueWrapper(){
        return measurementValueWrapper.getHeightValueWrapper();
    }    
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/ContainerSetFXML.fxml";
    }


}
