package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.Plants;

/**
 *
 * @author zc
 */
public class EditPlantDataModel extends AbstractPlantDataModel {

    /**
     * Construct an object.
     *
     * @param plant - The plant to be edited.
     * @throws IndexOutOfBoundsException if no plant group can be selected from
     * the plant group list.
     */
    public EditPlantDataModel(Plants plant) {
        super(new PlantValueWrapper(plant));
    }

    public PlantGroup getPlantGroup() {
        return getValueWrapper().getPlantGroupValueWrapper().getValue();
    }

    public PlantSubGroup getPlantSubGroup() {
        return getValueWrapper().getPlantSubGroupValueWrapper().getValue();
    }

    public PlantVariety getPlantVariety() {
        return getValueWrapper().getPlantVarietyValueWrapper().getValue();
    }

    @Override
    public void save() {
        get().setValues(getValueWrapper());        
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/plant/EditPlantFXML.fxml";
    }
}
