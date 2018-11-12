package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.data.other.SolidFertiliserDetailValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class SolidFertiliserDataModel extends PartDataModel<FertiliserType, SolidFertiliserDetailValueWrapper>{

    private final ObservableListWrapperA<String> densityUoms;
    
    public SolidFertiliserDataModel(SolidFertiliserDetailValueWrapper itemPartValueWrapper) {
        super(itemPartValueWrapper);
        densityUoms = ProjectManager.getInstance().getProject().getSolidFertiliserDensityUoms();
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
