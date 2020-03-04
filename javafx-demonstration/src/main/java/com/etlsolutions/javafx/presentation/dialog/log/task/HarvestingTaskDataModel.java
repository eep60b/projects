package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTaskValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.gwise.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class HarvestingTaskDataModel extends TaskDetailDataModel<HarvestingTaskValueWrapper> {

    private final ObservableListWrapperA<String> harvestingQualities;
    private final ObservableListWrapperA<String> harvestingUoms;
    
    public HarvestingTaskDataModel(HarvestingTask task) {
        this(new HarvestingTaskValueWrapper(task));
    }    
    
    public HarvestingTaskDataModel(HarvestingTaskValueWrapper detail) {
        super(detail);
        ProjectContents p = ProjectManager.getInstance().getContents();
        harvestingQualities = new ObservableListWrapperA<>(p.getHarvestingQualities());
        harvestingUoms = new ObservableListWrapperA<>(p.getHarvestingUoms());
    }

    public ObservableListWrapperA<String> getHarvestingQualities() {
        return harvestingQualities;
    }

    public ObservableListWrapperA<String> getHarvestingUoms() {
        return harvestingUoms;
    }
    
    public ValueWrapper<String> getQuality() {
        return detail.getQualityValueWrapper();
    }

    public ValueWrapper<String> getQuatantity() {
        return detail.getQuatantityValueWrapper();
    }

    public ValueWrapper<String> getUom() {
        return detail.getUomValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/HarvestingTaskFXML.fxml";
    }

    @Override
    public void save() {

    }

    @Override
    public void remove(RemoveEventId id) {

    }
}
