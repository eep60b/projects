package com.etlsolutions.javafx.presentation.dialog.plantgroup;

import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddPlantGroupDataModel extends AbstractPlantGroupDataModel{

    
    public AddPlantGroupDataModel() {
        super(PlantsFactory.getInstance().createDefaultPlantGroupValueWrapper());
    }

    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantGroup(getValueWrapper()));
    }
    
}
