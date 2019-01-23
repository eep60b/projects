package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.growingissue.EditGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.EditGventDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class PlantGrowingIssuePropertyChangeAdapter implements PropertyChangeListener {

    private final ListView<GrowingIssue> growingIssueListView;
    private final Button editGrowingIssueButton;
    private final Button removeGrowingIssueButton;

    PlantGrowingIssuePropertyChangeAdapter(ListView<GrowingIssue> gventListView, Button editGrowingIssueButton, Button removeGrowingIssueButton) {
        this.growingIssueListView = gventListView;
        this.editGrowingIssueButton = editGrowingIssueButton;
        this.removeGrowingIssueButton = removeGrowingIssueButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<GrowingIssue>) evt.getSource());
    }

    public void process(ValueWrapper<GrowingIssue> wrapper) {
        boolean hasGvent = wrapper.getValue() != null;
        editGrowingIssueButton.setDisable(!hasGvent);
        removeGrowingIssueButton.setDisable(!hasGvent);
        if (hasGvent) {
            EditGrowingIssueDataModel gm = new EditGrowingIssueDataModel(wrapper.getValue());
            gm.addPropertyChangeListener(EditGrowingIssueDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(growingIssueListView));
            editGrowingIssueButton.setOnAction(new EditItemEventHandler(gm));
        }
    }
}
