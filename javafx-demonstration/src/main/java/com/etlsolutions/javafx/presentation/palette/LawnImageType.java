package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.gwise.system.SettingConstants;
import java.io.File;

/**
 *
 * @author zc
 */
public enum LawnImageType implements ImageType {

    RECTANGLE("lawn-rectangle.png", MeasurementType.RECTANGLE);

    private final String fileName;
    private final MeasurementType measurementType;

    private LawnImageType(String fileName, MeasurementType measurementType) {

        this.fileName = fileName;
        this.measurementType = measurementType;
    }

    @Override
    public String getFilePath() {
        return SettingConstants.LOGO_DIRECTORY_LAWN + File.separator + fileName;
    }

    @Override
    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    @Override
    public SubAreaType getSubAreaType() {        
        return SubAreaType.LAWN;
    }
}
