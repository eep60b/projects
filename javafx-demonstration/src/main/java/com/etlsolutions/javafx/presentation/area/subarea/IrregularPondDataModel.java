package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;

/**
 *
 * @author zc
 */
public class IrregularPondDataModel extends MeasurementDataModel<IrregularMeasurementValueWrapper>  {

    private final String title;

    public IrregularPondDataModel(String title, IrregularMeasurement measurement) {
        super(new IrregularMeasurementValueWrapper(measurement));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ValueWrapper<String> getAreaValueWrapper() {
        return measurementValueWrapper.getAreaValueWrapper();
    }
    
    public ValueWrapper<String> getHeightValueWrapper() {
        return measurementValueWrapper.getHeightValueWrapper();
    }    
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/IrregularPondFXML.fxml";
    }
}
