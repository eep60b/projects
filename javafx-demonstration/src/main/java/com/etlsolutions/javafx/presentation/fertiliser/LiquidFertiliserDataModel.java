package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.LiquidFertiliserDetailValueWrapper;

/**
 *
 * @author zc
 */
public class LiquidFertiliserDataModel extends PartDataModel<FertiliserType, LiquidFertiliserDetailValueWrapper>{

    public LiquidFertiliserDataModel(LiquidFertiliserDetailValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
    }

    
    @Override
    public String getFxmlPath() {
        return "/fxml/other/LiquidFertiliserFXML.fxml";
    }
}