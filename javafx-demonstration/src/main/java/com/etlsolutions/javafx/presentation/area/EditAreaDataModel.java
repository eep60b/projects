package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;

/**
 *
 * @author Zhipeng
 */
public class EditAreaDataModel extends AbstractAreaDataModel {


    public EditAreaDataModel(Area area) {
        super(new ObservableListWrapperA<>(area.getType()));
        this.area = area;
        selectedAreaType = area.getType();
        selectedAreaShapeType = area.getMeasurement().getType();
    }

   
    @Override
    public void save() {        
        area.setTitle(title);
        area.setInformation(information);
        area.getImageLinks().clear();
        area.getImageLinks().addAll(imageLinks);
        area.setSelectedImgLinkIndex(imageLinks.indexOf(getSelectedImageLink()));
        area.setLongitude(getLongitude());
        area.setLatitude(getLatitude());
        area.setMeasurement(getMeasurement());
    }
}
