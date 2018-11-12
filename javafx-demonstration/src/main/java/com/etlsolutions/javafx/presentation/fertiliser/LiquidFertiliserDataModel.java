package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.LiquidFertiliserDetailValueWrapper;

/**
 *
 * @author zc
 */
public class LiquidFertiliserDataModel extends PartDataModel<FertiliserType, LiquidFertiliserDetailValueWrapper> {

    private ObservableListWrapperA<String> dilutionRationUoms;
    
    public LiquidFertiliserDataModel(LiquidFertiliserDetailValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
     
    }

    public ObservableListWrapperA<String> getDilutionRationUoms() {
        return dilutionRationUoms;
    }

    public ValueWrapper<Boolean> getDiluted() {
        return itemPartValueWrapper.getDiluted();
    }

    public ValueWrapper<String> getDilutionRatio() {
        return itemPartValueWrapper.getDilutionRatio();
    }

    public ValueWrapper<String> getDilutionRatioUom() {
        return itemPartValueWrapper.getDilutionRatioUom();
    }

    public FertiliserType getType() {
        return itemPartValueWrapper.getType();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/other/LiquidFertiliserPartFXML.fxml";
    }
}
