package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class FertilisationTaskDetailValueWrapper extends TaskDetailValueWrapper {

    private final ValueWrapper<Fertiliser> fertiliser;
    private final ValueWrapper<String> amountValueWrapper;
    private final ValueWrapper<String> uomValueWrapper;

    public FertilisationTaskDetailValueWrapper() {
        ProjectContents c = ProjectManager.getInstance().getContents();
        fertiliser = new ValueWrapper<>(c.getFertilisers().get(0));
        amountValueWrapper = new ValueWrapper<>("0");
        uomValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().getContents().getFertiliserUoms().get(0));
    }

    public FertilisationTaskDetailValueWrapper(FertilisationTask task) {
        
        super(task);
        fertiliser = new ValueWrapper<>(ProjectManager.getInstance().<Fertiliser>getItem(task.getFertiliserId()));
        amountValueWrapper = new ValueWrapper<>(String.valueOf(task.getAmount()));
        uomValueWrapper = new ValueWrapper<>(task.getUom());
    }

    public ValueWrapper<Fertiliser> getFertiliserValueWrapper() {
        return fertiliser;
    }

    public ValueWrapper<String> getAmountValueWrapper() {
        return amountValueWrapper;
    }

    public double getAmount() {
        return Double.parseDouble(amountValueWrapper.getValue());
    }
    
    public ValueWrapper<String> getUomValueWrapper() {
        return uomValueWrapper;
    }

    public void setUom(String uom) {
        this.uomValueWrapper.setValue(uom);
    }

    @Override
    public TaskType getType() {
        return TaskType.FERTILZATION;
    }
}
