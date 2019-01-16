package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroupValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class EditPlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {
    
    private final PlantGroup group;
    
    public EditPlantSubGroupDataModel(PlantSubGroup subGroup) {
        super(new PlantSubGroupValueWrapper(subGroup));
        group = ProjectManager.getInstance().getItem(subGroup.getPlantGroupId());
    }
      
    public String getPlantGroupTitle() {
        return group.getTitle();
    }    
    
    @Override
    public void save() {
        get().setValues(getValueWrapper());
    }

    @Override
    public String getFxmlPath() {
          return "/fxml/plant/EditPlantSubGroupFXML.fxml";
    }
}
