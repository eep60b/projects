package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author zc
 */
public class PlantVarietySelectionProertyChangeAdapter implements PropertyChangeListener {

    private final Button editVarityButton;
    private final Button removeVarityButton;
    private final ListView<PlantVariety> listView;

    public PlantVarietySelectionProertyChangeAdapter(Button editVarityButton, Button removeVarityButton, ListView<PlantVariety> listView) {
        this.editVarityButton = editVarityButton;
        this.removeVarityButton = removeVarityButton;
        this.listView = listView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddPlantTypeDataModel model = (AddPlantTypeDataModel) evt.getSource();
        PlantVariety v = model.getSelectedVariety();
        boolean noSelection = v == null;
        editVarityButton.setDisable(noSelection);
        removeVarityButton.setDisable(noSelection);   
        listView.getSelectionModel().select(v);
    }
}
