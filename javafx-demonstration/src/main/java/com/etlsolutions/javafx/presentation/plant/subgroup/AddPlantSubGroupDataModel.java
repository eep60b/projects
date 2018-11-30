package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddPlantSubGroupDataModel extends AbstractPlantSubGroupDataModel {

    private final ProjectManager manager = ProjectManager.getInstance();

    private final PlantGroup group;

    public AddPlantSubGroupDataModel(PlantGroup group) {
        this.group = group;
    }

    public PlantGroup getGroup() {
        return group;
    }

    @Override
    public void save() {

        set(PlantsFactory.getInstance().creatPlantSubGroup(commonValueWrapper, group.getId(), getVarieties()));
        group.getPlantsSubGroups().add(get());
        manager.addItem(get());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/AddPlantSubGroupFXML.fxml";
    }
}
