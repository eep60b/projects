package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreaListChangeAdapter implements ListChangeListener<SubArea> {

    private final ComboBox<SubArea> subareaComboBox;
    private final Button removeSubareaButton;
    private final Button editSubareaButton;
    private final AbstractLocationDataModel model;

    public SubAreaListChangeAdapter(ComboBox<SubArea> subareaComboBox, Button removeSubareaButton, Button editSubareaButton, AbstractLocationDataModel model) {
        this.subareaComboBox = subareaComboBox;
        this.removeSubareaButton = removeSubareaButton;
        this.editSubareaButton = editSubareaButton;
        this.model = model;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends SubArea> c) {
        subareaComboBox.setItems(model.getSubAreas());
        removeSubareaButton.setDisable(model.getSubAreas().size() <= 1);
        editSubareaButton.setDisable(model.getSubAreas().size() < 1);
    }
}
