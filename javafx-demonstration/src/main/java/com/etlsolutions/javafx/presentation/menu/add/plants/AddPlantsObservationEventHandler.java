package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.add.growingobservation.AddObservationEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.growingobservation.AddObservationDataModel;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.menu.add.growingissue.AddGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingissue.AddGrowingIssueEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsObservationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddPlantsObservationEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddObservationDataModel issueModel = new AddObservationDataModel();
        AddObservationEventHandler handler = new AddObservationEventHandler(issueModel);
        handler.handle(event);
        GrowingObservation observation = issueModel.getGrowingObservation();
        model.getObservations().add(observation);
        model.setSelectedGrowingObservation(observation);
    }
}
