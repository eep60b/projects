package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.gwise.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class WateringTaskValueWrapper extends TaskValueWrapper {
    
    private final ValueWrapper<WateringType> wateringTypeValueWrapper;
    private final ValueWrapper<WaterType> waterTypeValueWrapper;
    private final ValueWrapper<Boolean> fertilisedValueWrapper;
    private final ValueWrapper<LiquidFertiliser> fertiliserValueWrapper;
    private final ValueWrapper<String> amountValueWrapper;
    private final ValueWrapper<String> amountUomValueWrapper;
    private final ValueWrapper<String> fluxValueWrapper;
    private final ValueWrapper<String> fluxUomValueWrapper;
    private final ValueWrapper<Integer> durationValueWrapper;

    public WateringTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, WateringType wateringType, WaterType waterType, boolean fertilised, LiquidFertiliser fertiliser, double amount, String amountUom, double flux, String fluxUom, int duration) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
        wateringTypeValueWrapper = new ValueWrapper<>(wateringType);
        waterTypeValueWrapper = new ValueWrapper<>(waterType);
        fertilisedValueWrapper = new ValueWrapper<>(fertilised);
        fertiliserValueWrapper = new ValueWrapper<>(fertiliser);
        amountValueWrapper = getWrapper(amount);
        amountUomValueWrapper = new ValueWrapper<>(amountUom);
        fluxValueWrapper = getWrapper(flux);
        fluxUomValueWrapper = new ValueWrapper<>(fluxUom);
        durationValueWrapper = new ValueWrapper<>(duration); 
    }

    public WateringTaskValueWrapper(WateringTask task) {
        super(task);
        wateringTypeValueWrapper = new ValueWrapper<>(task.getWateringType());
        waterTypeValueWrapper = new ValueWrapper<>(task.getWaterType());
        fertilisedValueWrapper = new ValueWrapper<>(task.isFertilised());
        fertiliserValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<LiquidFertiliser>getItem(task.getFertiliserId()));
        amountValueWrapper = new ValueWrapper<>(String.valueOf(task.getAmount()));
        amountUomValueWrapper = new ValueWrapper<>(task.getAmountUom());
        fluxValueWrapper = new ValueWrapper<>("0");
        fluxUomValueWrapper = new ValueWrapper<>(task.getFluxUom());
        durationValueWrapper = new ValueWrapper<>(task.getDuration()); 
    }

    public ValueWrapper<WateringType> getWateringTypeValueWrapper() {
        return wateringTypeValueWrapper;
    }

    public ValueWrapper<WaterType> getWaterTypeValueWrapper() {
        return waterTypeValueWrapper;
    }

    public ValueWrapper<Boolean> getFertilisedValueWrapper() {
        return fertilisedValueWrapper;
    }

    public ValueWrapper<LiquidFertiliser> getFertiliserValueWrapper() {
        return fertiliserValueWrapper;
    }

    public ValueWrapper<String> getAmountValueWrapper() {
        return amountValueWrapper;
    }

    public ValueWrapper<String> getAmountUomValueWrapper() {
        return amountUomValueWrapper;
    }

    public ValueWrapper<String> getFluxValueWrapper() {
        return fluxValueWrapper;
    }

    public ValueWrapper<String> getFluxUomValueWrapper() {
        return fluxUomValueWrapper;
    }

    public ValueWrapper<Integer> getDurationValueWrapper() {
        return durationValueWrapper;
    }

    @Override
    public TaskType getType() {
        return TaskType.WATERING;
    }

    public double getAmount() {
        return Double.parseDouble(amountValueWrapper.getValue());
    }

    public double getFlux() {
        return Double.parseDouble(fluxValueWrapper.getValue());
    }
}
