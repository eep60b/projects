package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTaskValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public class PlantThinningTaskDataModel extends TaskDetailDataModel<PlantThinningTaskValueWrapper> {

    public PlantThinningTaskDataModel(PlantThinningTaskValueWrapper wrapper) {
        super(wrapper);
    }
    
    public PlantThinningTaskDataModel(PlantThinningTask task) {
        super(new PlantThinningTaskValueWrapper(task));
    }

    public ValueWrapper<Integer> getTotalPlants() {
        return detail.getTotalPlantsValueWrapper();
    }

    public ValueWrapper<Integer> getThinningRatio() {
        return detail.getThinningRatioValueWrapper();
    }
    
    public String getRemainPlants() {
        int ratio = detail.getThinningRatioValueWrapper().getValue();
        return String.valueOf(ratio == 0 ? 0 : detail.getTotalPlantsValueWrapper().getValue()/ratio);
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/PlantThinningFXML.fxml";
    }

    @Override
    public void save() {
    }

    @Override
    public void remove(RemoveEventId id) {        
    }  
}
