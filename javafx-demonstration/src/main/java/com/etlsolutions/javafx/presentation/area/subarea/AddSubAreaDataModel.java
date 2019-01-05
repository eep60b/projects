package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaValueWrapper;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public AddSubAreaDataModel(Area area) {
        super(area.getSubAreas().isEmpty() ? SubAreaFactory.getInstance().getDefaultSubAreaValueWrapper() : new SubAreaValueWrapper(area.getSubAreas().get(0)), area);
    }

    @Override
    public void save() {
        set(SubAreaFactory.getInstance().createSubArea(selectedSubAreaTypeValueWrapper.getValue(), getValueWrapper(), measurementDataModel.getMeasurementValueWrapper().getMeasurement()));
        area.getSubAreas().add(get());
    }
}