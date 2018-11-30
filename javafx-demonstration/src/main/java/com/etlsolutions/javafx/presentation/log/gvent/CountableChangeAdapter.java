package com.etlsolutions.javafx.presentation.log.gvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.HBox;

/**
 *
 * @author zc
 */
public class CountableChangeAdapter implements ChangeListener<Boolean> {
    
    private final FloweringGventDetailDataModel model;
    private final HBox countHBox;
    
    public CountableChangeAdapter(FloweringGventDetailDataModel model,  HBox countHBox) {
        this.model = model;
        this.countHBox = countHBox;
    }
    
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        
        countHBox.setVisible(newValue);
        
        if (newValue) {
            model.getNumberPerPlantValueWrapper().setValue(0);
            return;
        }
         model.getNumberPerPlantValueWrapper().setValue(-1);
    }
    
}
