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
public enum RaisedPlantBedImageType implements ImageType {

    RECTANGLE("raised-plant-bed-rectangle.png", MeasurementType.RECTANGLE);

    private final String fileName;
    private final MeasurementType measurementType;

    private RaisedPlantBedImageType(String fileName, MeasurementType measurementType) {

        this.fileName = fileName;
        this.measurementType = measurementType;
    }

    @Override
    public String getFilePath() {
        return SettingConstants.RAISED_PLANT_BED_LOGO_DIRECTORY + File.separator + fileName;
    }

    @Override
    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    @Override
    public SubAreaType getSubAreaType() {        
        return SubAreaType.PLANT_BED;
    }
}
