package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class AreaSelectionPropertyChangeAdapter implements PropertyChangeListener {
    
    private final AbstractLocationDataModel model;
    private final ComboBox<SubArea> subareaComboBox;

    public AreaSelectionPropertyChangeAdapter(AbstractLocationDataModel model, ComboBox<SubArea> subareaComboBox) {
        this.model = model;
        this.subareaComboBox = subareaComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        subareaComboBox.setItems(model.getSubAreas());
        subareaComboBox.getSelectionModel().select(model.getSelectedSubArea().getValue());
    }  
}
