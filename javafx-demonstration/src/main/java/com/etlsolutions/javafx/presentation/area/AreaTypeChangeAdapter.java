package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Zhipeng
 */
public class AreaTypeChangeAdapter implements ChangeListener<AreaType> {

    private final AbstractAreaDataModel model;
    private final ComboBox<AreaShape> shapeComboBox;

    public AreaTypeChangeAdapter(AbstractAreaDataModel model, ComboBox<AreaShape> shapeComboBox) {
        this.model = model;
        this.shapeComboBox = shapeComboBox;
    }

    @Override
    public void changed(ObservableValue<? extends AreaType> observable, AreaType oldValue, AreaType newValue) {
        model.setSelectedAreaType(newValue);
        shapeComboBox.setItems(model.getAreaShapes());
        shapeComboBox.getSelectionModel().select(model.getSelectedAreaShape());
    }
    
}
