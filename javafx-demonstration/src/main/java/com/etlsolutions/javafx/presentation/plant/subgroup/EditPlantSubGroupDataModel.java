package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;

/**
 *
 * @author zc
 */
public abstract class EditPlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {
    
    public EditPlantSubGroupDataModel(PlantSubGroup subGroup) {
        super(subGroup);
    }
      
    @Override
    public void save() {
        get().setCommonValues(commonValueWrapper);
        get().setPlantVarieties(getVarieties());
    }

    @Override
    public String getFxmlPath() {
          return "/fxml/plant/EditPlantSubGroupFXML.fxml";
    }
}
