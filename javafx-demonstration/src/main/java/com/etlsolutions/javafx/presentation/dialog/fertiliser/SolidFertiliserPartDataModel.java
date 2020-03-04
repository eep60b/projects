package com.etlsolutions.javafx.presentation.dialog.fertiliser;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.gwise.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.SolidFertiliserSpecialValueWrapper;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class SolidFertiliserPartDataModel extends PartDataModel<FertiliserType, SolidFertiliserSpecialValueWrapper>{

    private final ObservableListWrapperA<String> densityUoms;
    
    public SolidFertiliserPartDataModel(SolidFertiliserSpecialValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
        densityUoms = ProjectManager.getInstance().getContents().getSolidFertiliserDensityUoms();
    }

    public ObservableListWrapperA<String> getDensityUoms() {
        return densityUoms;
    }
    
    public ValueWrapper<String> getDensity() {
        return itemPartValueWrapper.getDensity();
    }

    public ValueWrapper<String> getDensityUom() {
        return itemPartValueWrapper.getDensityUom();
    }

    public FertiliserType getType() {
        return itemPartValueWrapper.getType();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/other/SolidFertiliserPartFXML.fxml";
    }
}
