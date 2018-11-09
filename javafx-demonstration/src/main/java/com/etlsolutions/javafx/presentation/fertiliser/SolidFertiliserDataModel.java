package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.SolidFertiliserDetailValueWrapper;

/**
 *
 * @author zc
 */
public class SolidFertiliserDataModel extends PartDataModel<FertiliserType, SolidFertiliserDetailValueWrapper>{

    public SolidFertiliserDataModel(SolidFertiliserDetailValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
    }

    
    @Override
    public String getFxmlPath() {
        return "/fxml/other/SolidFertiliserFXML.fxml";
    }
}
