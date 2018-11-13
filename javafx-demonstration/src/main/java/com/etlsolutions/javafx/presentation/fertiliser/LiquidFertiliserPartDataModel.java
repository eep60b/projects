package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.LiquidFertiliserSpecialValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class LiquidFertiliserPartDataModel extends PartDataModel<FertiliserType, LiquidFertiliserSpecialValueWrapper> {

    private final ObservableListWrapperA<String> dilutionRationUoms;
    
    public LiquidFertiliserPartDataModel(LiquidFertiliserSpecialValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
        dilutionRationUoms = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFertiliserDelutionRatioUoms());
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
