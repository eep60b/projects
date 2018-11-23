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
        super(area, new SubAreaType[]{subArea.getType()}, subArea.getMeasurement());
        this.dataUnit = subArea;
    }

    @Override
    public void save() {
        dataUnit.setTitle(getTitle().getValue());
        dataUnit.setInformation(getInformationValueWrapper().getValue());
        area.getImageLinks().clear();
        area.getImageLinks().addAll(getImageLinks());
        dataUnit.setMeasurement(measurementDataModel.getValue().getMeasurementValueWrapper().getMeasurement());
    }
}
