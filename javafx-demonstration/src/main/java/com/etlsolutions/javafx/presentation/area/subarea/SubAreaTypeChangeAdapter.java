package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreaTypeChangeAdapter implements ChangeListener<SubAreaType> {

    private final AbstractSubAreaDataModel model;
    private final ComboBox<SubAreaShape> shapeComboBox;    

    public SubAreaTypeChangeAdapter(AbstractSubAreaDataModel model, ComboBox<SubAreaShape> shapeComboBox) {
        this.model = model;
        this.shapeComboBox = shapeComboBox;
    }

    @Override
    public void changed(ObservableValue<? extends SubAreaType> observable, SubAreaType oldValue, SubAreaType newValue) {
        model.setSelectedSubAreaType(newValue);
        shapeComboBox.setItems(model.getShapes());
        shapeComboBox.getSelectionModel().select(model.getSelectedSubAreaShape());
    }

}
