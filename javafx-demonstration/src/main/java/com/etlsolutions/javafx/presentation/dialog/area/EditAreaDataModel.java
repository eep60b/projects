package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;

/**
 *
 * @author Zhipeng
 */
public class EditAreaDataModel extends AbstractAreaDataModel {

    public EditAreaDataModel(Area area) {
        super(area, new ObservableListWrapperA<>(area.getType()), area.getMeasurement());
    }
    
    @Override
    public void save() {    
        Area dataUnit = get();
        dataUnit.setTitle(getTitleValueWrapper().getValue());
        dataUnit.setInformation(getInformationValueWrapper().getValue());
        dataUnit.getImageLinks().clear();
        dataUnit.getImageLinks().addAll(getImageLinks());
        dataUnit.setSelectedImgLinkIndex(getImageLinks().indexOf(getSelectedImageLinkWrapper().getValue()));
        dataUnit.setLongitude(getValueWrapper().getLongitude());
        dataUnit.setLatitude(getValueWrapper().getLatitude());
        dataUnit.setMeasurement(measurementDataModel.getMeasurementValueWrapper().getMeasurement());
    }
}
