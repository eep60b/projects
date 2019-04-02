package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.system.ProjectManager;
import com.etlsolutions.javafx.system.SettingConstants;
import java.io.File;

/**
 *
 * @author zc
 */
public enum PondImageType implements ImageType {

    RECTANGLE("pond-rectangle.png", MeasurementType.RECTANGLE);

    private final String fileName;
    private final MeasurementType measurementType;

    private PondImageType(String fileName, MeasurementType measurementType) {

        this.fileName = fileName;
        this.measurementType = measurementType;
    }

    @Override
    public String getFilePath() {
        return SettingConstants.RELATIVE_POND_LOGO_DIRECTORY + File.separator + fileName;
    }

    @Override
    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    @Override
    public SubAreaType getSubAreaType() {        
        return SubAreaType.POND;
    }
}
