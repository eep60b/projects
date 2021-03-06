package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.gwise.data.area.AreaType;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.gwise.system.ProjectManager;
import java.util.Arrays;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDataModel extends AbstractAreaDataModel {

    public AddAreaDataModel() {
        super(AreaFactory.getInstance().getDefaultAreaValueWrapper(), new ObservableListWrapperA<>(Arrays.asList(AreaType.values())), new RectangleMeasurement());
    }

    @Override
    public void save() {
        set(AreaFactory.getInstance().createArea(selectedAreaTypeValueWrapper.getValue(), getValueWrapper(), measurementDataModel.getMeasurementValueWrapper(), subAreas));
        ProjectManager.getInstance().getContents().getAreaRoot().add(getItem());
    }
}
