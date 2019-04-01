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
public enum PlantBedImageType {

    RECTANGLE("plant-bed-rectangle.png", MeasurementType.RECTANGLE);

    private final String fileName;
    private final MeasurementType measurementType;

    private PlantBedImageType(String fileName, MeasurementType measurementType) {

        this.fileName = fileName;
        this.measurementType = measurementType;
    }

    public String getFilePath() {
        return ProjectManager.getInstance().getConfiguration().getProjectPath() + SettingConstants.RELATIVE_PLANT_BED_LOGO_DIRECTORY + File.separator + fileName;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public SubAreaType getSubAreaType() {        
        return SubAreaType.PLANT_BED;
    }
}
