package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import javafx.scene.control.RadioButton;

/**
 *
 * @author zc
 */
public class QuantityTypeRadioButton extends RadioButton {
    
    private Type type;

    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
}
