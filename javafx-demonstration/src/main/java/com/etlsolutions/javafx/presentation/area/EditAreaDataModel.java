package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;

/**
 *
 * @author Zhipeng
 */
public class EditAreaDataModel extends AbstractAreaDataModel {

    public EditAreaDataModel(Area area) {
        super(new ObservableListWrapperA<>(area.getType()), area.getMeasurement());
        dataUnit = area;
    }
    
    @Override
    public void save() {        
        dataUnit.setTitle(getTitle().getValue());
        dataUnit.setInformation(getInformationValueWrapper().getValue());
        dataUnit.getImageLinks().clear();
        dataUnit.getImageLinks().addAll(getImageLinks());
        dataUnit.setSelectedImgLinkIndex(getImageLinks().indexOf(getSelectedImageLinkWrapper().getValue()));
        dataUnit.setLongitude(areaValueWrapper.getLongitude());
        dataUnit.setLatitude(areaValueWrapper.getLatitude());
        dataUnit.setMeasurement(measurementDataModelValueWrapper.getValue().getMeasurementValueWrapper().getMeasurement());
    }
}
