package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class HarvestingTaskDetail implements TaskDetail {

    private final ValueWrapper<String> quality;
    private final ValueWrapper<Double> quatantity;
    private final ValueWrapper<String> uom;

    public HarvestingTaskDetail(String quality, double quatantity, String uom) {
        this.quality = new ValueWrapper<>(quality);
        this.quatantity = new ValueWrapper<>(quatantity);
        this.uom = new ValueWrapper<>(uom);
    }

    public ValueWrapper<String> getQuality() {
        return quality;
    }

    public ValueWrapper<Double> getQuatantity() {
        return quatantity;
    }
    
    public ValueWrapper<String> getUom() {
        return uom;
    }

    @Override
    public TaskType getType() {
        return TaskType.HARVESTING;
    }
}
