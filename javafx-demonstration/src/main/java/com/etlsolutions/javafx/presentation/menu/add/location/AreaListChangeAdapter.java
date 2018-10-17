package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class AreaListChangeAdapter implements ListChangeListener<Area> {

    private final ComboBox<Area> areaComboBox;
    private final AddLocationDataModel model;

    public AreaListChangeAdapter(ComboBox<Area> areaComboBox, AddLocationDataModel model) {        
        this.areaComboBox = areaComboBox;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends Area> c) {
         areaComboBox.setItems(model.getAreas());
    }  
}
