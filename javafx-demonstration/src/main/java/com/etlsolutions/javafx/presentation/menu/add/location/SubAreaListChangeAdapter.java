package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreaListChangeAdapter implements ListChangeListener<SubArea> {
    
    private final ComboBox<SubArea> areaComboBox;
    private final AddLocationDataModel model;
    
    public SubAreaListChangeAdapter(ComboBox<SubArea> areaComboBox, AddLocationDataModel model) {        
        this.areaComboBox = areaComboBox;
        this.model = model;
    }
    
    @Override
    public void onChanged(ListChangeListener.Change<? extends SubArea> c) {
        areaComboBox.setItems(model.getSubAreas());
        areaComboBox.getSelectionModel().select(model.getSelectedSubArea());
    }    
}
