package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaMeasurement;

/**
 *
 * @author Zhipeng
 */
public class EditAreaDataModel extends AbstractAreaDataModel {


    public EditAreaDataModel(Area area) {
        super(new ObservableListWrapperA<>(area.getType()), new  AreaMeasurement(area.getMeasurement()));
        dataUnit = area;
        selectedAreaType = area.getType();
        selectedAreaShape = area.getShape();
    }

   
    @Override
    public void save() {        
        dataUnit.setTitle(getTitle().getValue());
        dataUnit.setInformation(getInformation().getValue());
        dataUnit.getImageLinks().clear();
        dataUnit.getImageLinks().addAll(getImageLinks());
        dataUnit.setSelectedImgLinkIndex(getImageLinks().indexOf(getSelectedImageLinkWrapper().getValue()));
        dataUnit.setLongitude(getLongitude());
        dataUnit.setLatitude(getLatitude());
        dataUnit.setMeasurement(measurementDataModel.getMeasurement());
        dataUnit.setShape(selectedAreaShape);
    }
}
