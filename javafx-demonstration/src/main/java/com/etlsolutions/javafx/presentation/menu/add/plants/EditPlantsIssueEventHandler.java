package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.edit.issue.EditIssueEventHandler;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.menu.edit.issue.EditIssueDataModel;
import com.etlsolutions.javafx.data.log.FirstDateComparator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditPlantsIssueEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;
    private final ListView<GrowingIssue> listView;

    public EditPlantsIssueEventHandler(AddPlantsDataModel model, ListView<GrowingIssue> listView) {
        this.model = model;
        this.listView = listView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        GrowingIssue issure = model.getSelectedGrowingIssue();
        EditIssueDataModel m = new EditIssueDataModel(issure);        
        EditIssueEventHandler handler = new EditIssueEventHandler(m);
        handler.handle(event);
        listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), issure);
        listView.getItems().sort(new FirstDateComparator<GrowingIssue>());
    }
    
}