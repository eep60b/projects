package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.other.Fertiliser;

/**
 *
 * @author zc
 */
public class FertilisationTaskDetail implements TaskDetail {

    private final ValueWrapper<Fertiliser> fertiliser;
    private final ValueWrapper<Double> amount;
    private final ValueWrapper<String> uom;

    public FertilisationTaskDetail(Fertiliser fertiliser, double amount, String uom) {
        this.fertiliser = new ValueWrapper<>(fertiliser);
        this.amount = new ValueWrapper<>(amount);
        this.uom = new ValueWrapper<>(uom);
    }

    public ValueWrapper<Fertiliser> getFertiliser() {
        return fertiliser;
    }

    public ValueWrapper<Double> getAmount() {
        return amount;
    }

    public ValueWrapper<String> getUom() {
        return uom;
    }

  

    public void setUom(String uom) {
        this.uom.setValue(uom);
    }

    @Override
    public TaskType getType() {
        return TaskType.FERTILZATION;
    }
}
