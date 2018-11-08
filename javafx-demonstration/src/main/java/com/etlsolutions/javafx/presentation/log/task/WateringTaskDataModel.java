package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.task.WaterType;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.log.task.WateringTaskDetail;
import com.etlsolutions.javafx.data.log.task.WateringType;
import com.etlsolutions.javafx.data.other.LiquidFertiliser;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class WateringTaskDataModel extends TaskDetailDataModel<WateringTaskDetail> {

    private final ObservableListWrapperA<String> wateringAmountUoms;
    private final ObservableListWrapperA<String> wateringFluxUoms;
    private final ObservableListWrapperA<LiquidFertiliser> fertilisers;
    
    public WateringTaskDataModel(WateringTask task) {
        this(new WateringTaskDetail(task.getWateringType(), task.getWaterType(), task.isFertilised(), 
                (LiquidFertiliser)ProjectManager.getInstance().getItem(task.getFertiliserId()), task.getAmount(), 
                task.getAmountUom(), task.getFlux(), task.getFluxUom(), task.getDuration()));
    }

    public WateringTaskDataModel() {
        this(LogFactory.getInstance().getDefaultWateringTaskDetail());
    }

    private WateringTaskDataModel(WateringTaskDetail detail) {
        
        super(detail);
        ProjectContents p = ProjectManager.getInstance().getProject();
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
        return detail.getWateringType();
    }

    public ValueWrapper<WaterType> getWaterType() {
        return detail.getWaterType();
    }

    public ValueWrapper<Boolean> getFertilised() {
        return detail.getFertilised();
    }

    public ValueWrapper<LiquidFertiliser> getFertiliser() {
        return detail.getFertiliser();
    }

    public ValueWrapper<String> getAmount() {
        return detail.getAmount();
    }

    public ValueWrapper<String> getAmountUom() {
        return detail.getAmountUom();
    }

    public ValueWrapper<String> getFlux() {
        return detail.getFlux();
    }

    public ValueWrapper<String> getFluxUom() {
        return detail.getFluxUom();
    }

    public ValueWrapper<Integer> getDuration() {
        return detail.getDuration();
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
