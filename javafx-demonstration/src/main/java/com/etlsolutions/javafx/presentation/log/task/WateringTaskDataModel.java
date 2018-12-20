package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.task.WaterType;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.log.task.WateringTaskDetailValueWrapper;
import com.etlsolutions.javafx.data.log.task.WateringType;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class WateringTaskDataModel extends TaskDetailDataModel<WateringTaskDetailValueWrapper> {

    private final ObservableListWrapperA<String> wateringAmountUoms;
    private final ObservableListWrapperA<String> wateringFluxUoms;
    private final ObservableListWrapperA<LiquidFertiliser> fertilisers;
    
    public WateringTaskDataModel(WateringTask task) {
        this(new WateringTaskDetailValueWrapper(task));
    }

    public WateringTaskDataModel() {
        this(LogFactory.getInstance().getDefaultWateringTaskDetail());
    }

    private WateringTaskDataModel(WateringTaskDetailValueWrapper detail) {
        
        super(detail);
        ProjectContents p = ProjectManager.getInstance().getContents();
        wateringAmountUoms = new ObservableListWrapperA<>(p.getWateringAmountUoms());
        wateringFluxUoms = new ObservableListWrapperA<>(p.getWateringFluxUoms());
        fertilisers = new ObservableListWrapperA<>(p.getLiquidFertilisers());
    }

    public ObservableListWrapperA<String> getWateringAmountUoms() {
        return wateringAmountUoms;
    }

    public ObservableListWrapperA<String> getWateringFluxUoms() {
        return wateringFluxUoms;
    }

    public ObservableListWrapperA<LiquidFertiliser> getFertilisers() {
        return fertilisers;
    }

    
    
    public ValueWrapper<WateringType> getWateringType() {
        return detail.getWateringTypeValueWrapper();
    }

    public ValueWrapper<WaterType> getWaterType() {
        return detail.getWaterTypeValueWrapper();
    }

    public ValueWrapper<Boolean> getFertilised() {
        return detail.getFertilisedValueWrapper();
    }

    public ValueWrapper<LiquidFertiliser> getFertiliser() {
        return detail.getFertiliserValueWrapper();
    }

    public ValueWrapper<String> getAmount() {
        return detail.getAmountValueWrapper();
    }

    public ValueWrapper<String> getAmountUom() {
        return detail.getAmountUomValueWrapper();
    }

    public ValueWrapper<String> getFlux() {
        return detail.getFluxValueWrapper();
    }

    public ValueWrapper<String> getFluxUom() {
        return detail.getFluxUomValueWrapper();
    }

    public ValueWrapper<Integer> getDuration() {
        return detail.getDurationValueWrapper();
    }

    
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/WateringTaskFXML.fxml";
    }

    @Override
    public void save() {
        
    }

    @Override
    public void remove(RemoveEventId id) {
        
    }

}
