package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class AreaListChangeAdapter implements ListChangeListener<Area> {

    private final ComboBox<Area> areaComboBox;
    private final Button removeAreaButton;
    private final Button editAreaButton;
    private final AbstractLocationDataModel model;

    public AreaListChangeAdapter(ComboBox<Area> areaComboBox, Button removeAreaButton, Button editAreaButton, AbstractLocationDataModel model) {
        this.areaComboBox = areaComboBox;
        this.removeAreaButton = removeAreaButton;
        this.editAreaButton = editAreaButton;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends Area> c) {
        
        areaComboBox.setItems(model.getAreas());
        removeAreaButton.setDisable(model.getAreas().size() <= 1);
        editAreaButton.setDisable(model.getAreas().size() < 1);
    }
}
