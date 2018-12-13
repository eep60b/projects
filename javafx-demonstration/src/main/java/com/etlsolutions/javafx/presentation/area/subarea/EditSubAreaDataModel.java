package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class EditSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public EditSubAreaDataModel(Area area, SubArea subArea) {
        super(subArea, area, new SubAreaType[]{subArea.getType()}, subArea.getMeasurement());

    }

    @Override
    public void save() {

        SubArea dataUnit = get();
        dataUnit.setCommonValues(commonValueWrapper);
        dataUnit.setMeasurement(measurementDataModel.getMeasurementValueWrapper().getMeasurement());
    }
}
