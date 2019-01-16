package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroupValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.RemoveFromListUtil;
import java.util.Objects;

/**
 *
 * @author zc
 */
public abstract class AbstractPlantSubGroupDataModel extends DataUnitFXMLDataModel<PlantSubGroup> {
    
    public static final RemoveEventId REMOVE_VARIETY_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDataModel.REMOVE_VARIETY_ID", "plant variety");
    
    private final PlantSubGroupValueWrapper valueWrapper;
    private final ValueWrapper<PlantVariety> selectedVarietyValueWrapper;

    public AbstractPlantSubGroupDataModel(PlantSubGroupValueWrapper valueWrapper) {
        this.valueWrapper = valueWrapper;
        ObservableListWrapperA<PlantVariety> varieties = valueWrapper.getPlantVarieties();
        selectedVarietyValueWrapper =new ValueWrapper<>(varieties.isEmpty() ? null : varieties.get(0));
    }


    public ObservableListWrapperA<PlantVariety> getVarieties() {
        return valueWrapper.getPlantVarieties();
    }

    public ValueWrapper<PlantVariety> getSelectedVarietyValueWrapper() {
        return selectedVarietyValueWrapper;
    }
    
    @Override
    public void remove(RemoveEventId id) {
        
        if(Objects.equals(id, REMOVE_VARIETY_ID)) {
            RemoveFromListUtil.getInstance().remove(valueWrapper.getPlantVarieties(), selectedVarietyValueWrapper);
        }
        
        super.remove(id); 
    }

    @Override
    protected final PlantSubGroupValueWrapper getValueWrapper() {
        
        return valueWrapper;
    }
}
