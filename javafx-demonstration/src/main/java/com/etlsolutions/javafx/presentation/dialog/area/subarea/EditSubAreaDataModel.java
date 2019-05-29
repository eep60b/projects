package com.etlsolutions.javafx.presentation.dialog.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaValueWrapper;

/**
 *
 * @author zc
 */
public class EditSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public EditSubAreaDataModel(Area area, SubArea subArea) {
        super(new SubAreaValueWrapper(subArea), subArea, area, new SubAreaType[]{subArea.getType()}, subArea.getMeasurement());

    }

    @Override
    public void save() {

        SubArea dataUnit = getItem();
        dataUnit.setCommonValues(getValueWrapper());
        dataUnit.setMeasurement(measurementDataModel.getMeasurementValueWrapper().getMeasurement());
    }
}
