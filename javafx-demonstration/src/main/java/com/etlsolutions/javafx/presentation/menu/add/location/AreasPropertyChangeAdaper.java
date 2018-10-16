package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class AreasPropertyChangeAdaper implements PropertyChangeListener {

    private final ComboBox<SubArea> subareaComboBox;
    private final Button removeAreaButton;

    public AreasPropertyChangeAdaper(ComboBox<SubArea> subareaComboBox, Button removeAreaButton) {
        this.subareaComboBox = subareaComboBox;
        this.removeAreaButton = removeAreaButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddLocationDataModel model = (AddLocationDataModel) evt.getSource();
        subareaComboBox.setItems(model.getSubAreas());
        subareaComboBox.getSelectionModel().select(model.getSelectedSubArea());
        boolean disabled = model.getAreas().size() <= 1;
        removeAreaButton.setDisable(disabled);
        subareaComboBox.setDisable(disabled);
    }
}
