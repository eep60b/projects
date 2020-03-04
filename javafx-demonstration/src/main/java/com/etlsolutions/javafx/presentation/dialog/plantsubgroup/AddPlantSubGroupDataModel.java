package com.etlsolutions.javafx.presentation.dialog.plantsubgroup;

import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddPlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {

    private final PlantGroup group;

    public AddPlantSubGroupDataModel(PlantGroup group) {
        super(PlantsFactory.getInstance().creatDefaultPlantSubGroupValueWrapper(group));
        this.group = group;        
    }

    public PlantGroup getGroup() {
        return group;
    }

    @Override
    public void save() {

        set(PlantsFactory.getInstance().creatPlantSubGroup(getValueWrapper()));
        group.getPlantSubGroups().add(getItem());
        ProjectManager.getInstance().addItem(getItem());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/AddPlantSubGroupFXML.fxml";
    }
}
