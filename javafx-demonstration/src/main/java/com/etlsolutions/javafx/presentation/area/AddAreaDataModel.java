package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Arrays;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDataModel extends AbstractAreaDataModel {

    public AddAreaDataModel() {
        super(new ObservableListWrapperA<>(Arrays.asList(AreaType.values())), new RectangleMeasurement());
    }

    @Override
    public void save() {
        dataUnit = AreaFactory.getInstance().createArea(selectedAreaTypeValueWrapper.getValue(), commonValueWrapper, areaValueWrapper, measurementDataModelValueWrapper.getValue().getMeasurementValueWrapper(), subAreas);
        ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas().add(dataUnit);
    }
}
