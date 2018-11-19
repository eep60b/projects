package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class EditSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public EditSubAreaDataModel(Area area, SubArea subArea) {
        super(area, new SubAreaType[]{subArea.getType()}, new Measurement(subArea.getMeasurement()));
        this.dataUnit = subArea;
        this.selectedSubAreaShape = subArea.getShape();
    }

    @Override
    public void save() {
        dataUnit.setTitle(getTitle().getValue());
        dataUnit.setInformation(getInformation().getValue());
        area.getImageLinks().clear();
        area.getImageLinks().addAll(getImageLinks());
        dataUnit.setMeasurement(measurementDataModel.getMeasurement());
        dataUnit.setShape(selectedSubAreaShape);
    }
}
