package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class HarvestingTaskDetailValueWrapper extends TaskDetailValueWrapper {

    private final ValueWrapper<String> quality;
    private final ValueWrapper<String> quatantity;
    private final ValueWrapper<String> uom;

    public HarvestingTaskDetailValueWrapper() {
        ProjectContents c = ProjectManager.getInstance().getContents();
        quality = new ValueWrapper<>(c.getHarvestingQualities().get(0));
        quatantity = new ValueWrapper<>("0");
        uom = new ValueWrapper<>(c.getHarvestingUoms().get(0));
    }

    public HarvestingTaskDetailValueWrapper(HarvestingTask task) {
        super(task);
        quality = new ValueWrapper<>(task.getQuality());
        quatantity = new ValueWrapper<>(String.valueOf(task.getQuatantity()));
        uom = new ValueWrapper<>(task.getUom());
    }

    public ValueWrapper<String> getQuality() {
        return quality;
    }

    public ValueWrapper<String> getQuatantityValueWrapper() {
        return quatantity;
    }

    public ValueWrapper<String> getUomValueWrapper() {
        return uom;
    }

    @Override
    public TaskType getType() {
        return TaskType.HARVESTING;
    }

    
    public double getQuatantity() {
        
        return Double.parseDouble(quatantity.getValue());
    }
}
