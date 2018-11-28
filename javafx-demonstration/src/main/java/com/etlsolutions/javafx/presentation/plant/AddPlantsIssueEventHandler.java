package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.growingissue.AbstractGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.log.growingissue.AddGrowingIssueDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsIssueEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddPlantsIssueEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AbstractGrowingIssueDataModel issueModel = new AddGrowingIssueDataModel();
        FXMLActionEventHandler<AbstractGrowingIssueDataModel> handler = new FXMLActionEventHandler<>(issueModel);
        handler.handle(event);
        GrowingIssue issue = issueModel.get();
        model.getGrowingIssues().add(issue);
        model.getSelectedGrowingIssueValueWrapper().setValue(issue);
    }
}
