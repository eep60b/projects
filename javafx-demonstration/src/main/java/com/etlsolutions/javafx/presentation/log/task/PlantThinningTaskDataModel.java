package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTaskDetail;
import com.etlsolutions.javafx.presentation.RemoveEventId;

/**
 *
 * @author zc
 */
public class PlantThinningTaskDataModel extends TaskDetailDataModel<PlantThinningTaskDetail> {

    public PlantThinningTaskDataModel() {
        super(new PlantThinningTaskDetail(1, 1));
    }
    
    public PlantThinningTaskDataModel(PlantThinningTask task) {
        super(new PlantThinningTaskDetail(task.getTotalPlants(), task.getThinningRatio()));
    }

    public ValueWrapper<Integer> getTotalPlants() {
        return detail.getTotalPlants();
    }

    public ValueWrapper<Integer> getThinningRatio() {
        return detail.getThinningRatio();
    }
    
    public String getRemainPlants() {
        int ratio = detail.getThinningRatio().getValue();
        return String.valueOf(ratio == 0 ? 0 : detail.getTotalPlants().getValue()/ratio);
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
