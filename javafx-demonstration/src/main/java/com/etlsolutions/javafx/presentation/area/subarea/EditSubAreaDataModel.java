package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class EditSubAreaDataModel extends AbstractSubAreaDataModel {

    public EditSubAreaDataModel(Area area, SubArea subArea) {
        super(area, subArea.getType());
        this.subArea = subArea;
        this.title = subArea.getTitle();
        this.information = subArea.getInformation();
        this.imageLinks = new ObservableListWrapperA<>(subArea.getImageLinks());
        this.measurement = new SubAreaMeasurement(subArea.getMeasurement());
        this.selectedSubAreaShape = subArea.getShape();
    }

    @Override
    public void save() {
        subArea.setTitle(title);
        subArea.setInformation(information);
        area.getImageLinks().clear();
        area.getImageLinks().addAll(imageLinks);
        subArea.setMeasurement(measurement);
        subArea.setShape(selectedSubAreaShape);
    }
}
