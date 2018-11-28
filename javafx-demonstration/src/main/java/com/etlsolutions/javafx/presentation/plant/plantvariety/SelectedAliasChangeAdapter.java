package com.etlsolutions.javafx.presentation.plant.plantvariety;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

/**
 *
 * @author zc
 */
public class SelectedAliasChangeAdapter implements PropertyChangeListener {

    private final Button removeAliasButton;
    private final ListView aliasListView;

    public SelectedAliasChangeAdapter(Button removeAliasButton, ListView aliasListView) {
        this.removeAliasButton = removeAliasButton;
        this.aliasListView = aliasListView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AbstractVarietyDataModel model = (AbstractVarietyDataModel) evt.getSource();
        String alias = model.getSelectedAliasWalueWrapper().getValue();
        removeAliasButton.setDisable(alias == null);
        MultipleSelectionModel selectionModel = aliasListView.getSelectionModel();
        selectionModel.clearSelection();
        if (alias != null) {
            selectionModel.select(alias);
        }
    }
}
