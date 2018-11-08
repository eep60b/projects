package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class EditSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public EditSubAreaDataModel(Area area, SubArea subArea) {
        super(area, new SubAreaType[]{subArea.getType()}, new SubAreaMeasurement(subArea.getMeasurement()));
        this.item = subArea;
        this.title = subArea.getTitle();
        this.information = subArea.getInformation();
        this.imageLinks = new ObservableListWrapperA<>(subArea.getImageLinks());
        this.selectedSubAreaShape = subArea.getShape();
    }

    @Override
    public void save() {
        item.setTitle(title);
        item.setInformation(information);
        area.getImageLinks().clear();
        area.getImageLinks().addAll(imageLinks);
       item.setMeasurement(measurementDataModel.getMeasurement());
        item.setShape(selectedSubAreaShape);
    }
}
