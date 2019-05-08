package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 * The ImageTyp interface define an image used in the palette.
 *
 * @author zc
 */
public interface ImageType {

    String getFilePath();

    /**
     * Get the measurement type of this object. It defines the shape to be drawn in the design pane.
     * @return 
     */
    MeasurementType getMeasurementType();

    /**
     * Get the sub-area type which this object represents.
     *
     * @return the sub-area type. It defines what to draw in the design pane.
     */
    SubAreaType getSubAreaType();
}
