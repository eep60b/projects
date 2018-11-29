package com.etlsolutions.javafx.presentation.plantgroup;

import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddPlantGroupDataModel extends AbstractPlantGroupDataModel{

    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantGroup(commonValueWrapper, plantSubGroups));
    }
    
}
