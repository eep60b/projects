package com.etlsolutions.javafx.presentation.dialog.plantgroup;

import com.etlsolutions.javafx.data.plant.PlantGroupValueWrapper;

/**
 *
 * @author zc
 */
public class EditPlantGroupDataModel extends AbstractPlantGroupDataModel{

    public EditPlantGroupDataModel(PlantGroupValueWrapper valueWrapper) {
        super(valueWrapper);
    }

    
    
    @Override
    public void save() {
        get().setValue(getValueWrapper());
    }
    
}
