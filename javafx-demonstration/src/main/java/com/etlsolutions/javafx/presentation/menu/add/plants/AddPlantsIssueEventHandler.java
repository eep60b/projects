package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.growingissue.AbstractGrowingIssueDataModel;
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
        AbstractGrowingIssueDataModel issueModel = new AbstractGrowingIssueDataModel();
        FXMLActionEventHandler<AbstractGrowingIssueDataModel> handler = new FXMLActionEventHandler<>(issueModel);
        handler.handle(event);
        GrowingIssue issue = issueModel.get();
        model.getIssues().add(issue);
        model.setSelectedGrowingIssue(issue);
    }
}
