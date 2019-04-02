package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public interface ImageType {
       
    String getFilePath();

    MeasurementType getMeasurementType();

    SubAreaType getSubAreaType();
}
