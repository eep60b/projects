package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
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
        super(plant);
    }

    public PlantGroup getPlantGroup() {
        return plantValueWrapper.getPlantGroupValueWrapper().getValue();
    }

    public PlantSubGroup getPlantSubGroup() {
        return plantValueWrapper.getPlantSubGroupValueWrapper().getValue();
    }

    public PlantVariety getPlantVariety() {
        return plantValueWrapper.getPlantVarietyValueWrapper().getValue();
    }

    @Override
    public void save() {
        Plants dataUnit = get();
        dataUnit.setCommonValues(commonValueWrapper);        
        dataUnit.setAlive(plantValueWrapper.getIsAliveValueWrapper().getValue());
        dataUnit.setGrowingIssueIds(plantValueWrapper.getGrowingIssueIds());
        dataUnit.setGrowingMediumId(plantValueWrapper.getGrowingMediumValueWrapper().getValue().getId());
        dataUnit.setGrowingObservationIds(plantValueWrapper.getGrowingObservationIds());
        dataUnit.setGrowingStartPoint(plantValueWrapper.getGrowingStartPointValueWrapper().getValue());
        dataUnit.setGventIds(plantValueWrapper.getGventIds());
        dataUnit.setLocationId(plantValueWrapper.getLocationValueWrapper().getValue().getId());
        dataUnit.setPlantVarietyId(plantValueWrapper.getPlantVarietyValueWrapper().getValue().getId());
        dataUnit.setQuantity(plantValueWrapper.getQuantityValueWrapper().getValue());
        dataUnit.setQuantityType(plantValueWrapper.getQuantityTypeValueWrapper().getValue());
        dataUnit.setStartTime(plantValueWrapper.getStartTime());
        dataUnit.setTaskIds(plantValueWrapper.getTaskIds());
        dataUnit.setTerminationReason(plantValueWrapper.getTerminationReasonValueWrapper().getValue());
        dataUnit.setTerminationTime(plantValueWrapper.getTerminationTime());
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/plant/EditPlantFXML.fxml";
    }
}
