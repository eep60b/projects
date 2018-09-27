package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
class SubAreaListChangeAdapter implements ListChangeListener<SubArea> {

    private final ComboBox<SubArea> areaComboBox;
    private final AddLocationWizardDataModel model;

    public SubAreaListChangeAdapter(ComboBox<SubArea> areaComboBox, AddLocationWizardDataModel model) {        
        this.areaComboBox = areaComboBox;
        this.model = model;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends SubArea> c) {
         areaComboBox.getSelectionModel().select(model.getSelectedSubArea());
    }  
}
