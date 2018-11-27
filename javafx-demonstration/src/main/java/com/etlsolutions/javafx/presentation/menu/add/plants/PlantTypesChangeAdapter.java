package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.DataUnitChangeAdapter;
import com.etlsolutions.javafx.data.plant.PlantGroup;

/**
 *
 * @author zc
 */
public class PlantTypesChangeAdapter extends DataUnitChangeAdapter {

    private final AddPlantsDataModel model;

    public PlantTypesChangeAdapter(PlantGroup group, AddPlantsDataModel model) {
        super(group);
        this.model = model;
    }

    @Override
    public void change() {
        
        PlantGroup group = (PlantGroup)getSource();
        
        if(group == model.getSelectedPlantGroupValueWrapper()) {
            model.setPlantTypes(group.getPlantsSubGroups());
        }
    }
    
}
