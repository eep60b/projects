package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.presentation.menu.add.location.AddLocationWizard;
import com.etlsolutions.javafx.presentation.menu.add.location.AddLocationWizardDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class AddLocationEventHandler implements EventHandler<ActionEvent> {

    private final AddLocationWizardDataModel wizardDataModel;

    public AddLocationEventHandler() {
        wizardDataModel = new AddLocationWizardDataModel();
    }
    
    
    
    @Override
    public void handle(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Add Location");
        AddLocationWizard wizard = new AddLocationWizard(stage, wizardDataModel);

        Scene scene = new Scene(wizard);
        stage.setScene(scene);
        stage.show();
    }

    public AddLocationWizardDataModel getWizardDataModel() {
        return wizardDataModel;
    }

}
