package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurementValueWrapper;

/**
 *
 * @author zc
 */
public class AreaValueDataModel extends MeasurementDataModel<IrregularMeasurementValueWrapper>  {

    public AreaValueDataModel(IrregularMeasurement measurement) {
        super(new IrregularMeasurementValueWrapper(measurement));
    }

    public ValueWrapper<String> getAreaValueWrapper() {
        return measurementValueWrapper.getAreaValueWrapper();
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/AreaValueFXML.fxml";
    }
}
