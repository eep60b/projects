package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.DialogActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.growingissue.AddGrowingIssueDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsIssueEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddPlantsIssueEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddGrowingIssueDataModel issueModel = new AddGrowingIssueDataModel();
        DialogActionEventHandler<AddGrowingIssueDataModel> handler = new DialogActionEventHandler<>(issueModel);
        handler.handle(event);
        GrowingIssue issue = issueModel.getGrowingIssue();
        model.getIssues().add(issue);
        model.setSelectedGrowingIssue(issue);
    }
}
