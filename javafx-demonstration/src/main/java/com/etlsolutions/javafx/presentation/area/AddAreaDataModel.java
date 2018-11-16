package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.AreaMeasurement;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Arrays;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDataModel extends AbstractAreaDataModel {

    public AddAreaDataModel() {
        super(new ObservableListWrapperA<>(Arrays.asList(AreaType.values())), new AreaMeasurement());
        selectedAreaType = areaTypes.get(0);
        selectedAreaShape = areaShapes.get(0);
    }

    @Override
    public void save() {
        dataUnit = AreaFactory.getInstance().createArea(selectedAreaType, commonValueWrapper, getLongitude(), getLatitude(), measurementDataModel.getMeasurement(), selectedAreaShape);
        ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas().add(dataUnit);
    }
}
