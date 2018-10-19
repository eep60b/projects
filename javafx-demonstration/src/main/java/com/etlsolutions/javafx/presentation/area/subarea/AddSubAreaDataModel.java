package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractSubAreaDataModel {

    public AddSubAreaDataModel(Area area) {
        super(area, SubAreaType.values());
        measurement = new SubAreaMeasurement();
    }

    @Override
    public void save() {
        subArea = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, title, information, imageLinks, imageLinks.indexOf(getSelectedImageLink()), "", selectedSubAreaShape, measurement);
        area.getSubAreas(selectedSubAreaType).add(subArea);
    }
}
