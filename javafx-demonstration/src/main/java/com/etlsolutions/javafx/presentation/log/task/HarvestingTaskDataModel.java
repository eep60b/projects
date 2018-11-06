package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTaskDetail;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class HarvestingTaskDataModel extends TaskDetailDataModel<HarvestingTaskDetail> {

    private final ObservableListWrapperA<String> harvestingQualities;
    private final ObservableListWrapperA<String> harvestingUoms;

    public HarvestingTaskDataModel() {
        this(new HarvestingTaskDetail(ProjectManager.getInstance().getProject().getHarvestingQualities().get(0), 
                0, ProjectManager.getInstance().getProject().getHarvestingUoms().get(0)));
    }    
    
    public HarvestingTaskDataModel(HarvestingTask task) {
        this(new HarvestingTaskDetail(task.getQuality(), task.getQuatantity(), task.getUom()));
    }    
    
    private HarvestingTaskDataModel(HarvestingTaskDetail detail) {
        super(detail);
        ProjectContents p = ProjectManager.getInstance().getProject();
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
        return detail.getQuality();
    }

    public ValueWrapper<String> getQuatantity() {
        return detail.getQuatantity();
    }

    public ValueWrapper<String> getUom() {
        return detail.getUom();
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
