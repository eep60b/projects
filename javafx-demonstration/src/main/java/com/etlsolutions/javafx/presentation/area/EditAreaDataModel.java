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
        item = area;
        selectedAreaType = area.getType();
        selectedAreaShape = area.getShape();
    }

   
    @Override
    public void save() {        
        item.setTitle(title);
        item.setInformation(information);
        item.getImageLinks().clear();
        item.getImageLinks().addAll(imageLinks);
        item.setSelectedImgLinkIndex(imageLinks.indexOf(getSelectedImageLink()));
        item.setLongitude(getLongitude());
        item.setLatitude(getLatitude());
        item.setMeasurement(measurementDataModel.getMeasurement());
        item.setShape(selectedAreaShape);
    }
}
