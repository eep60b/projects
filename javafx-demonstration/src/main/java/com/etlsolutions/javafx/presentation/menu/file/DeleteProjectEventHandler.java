package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.gwise.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author zc
 */
public class DeleteProjectEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        
        if (ProjectManager.getInstance().getConfiguration().getModified().getValue()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "The project is going to be permenantly removed. Do you want to proceed?", ButtonType.OK, ButtonType.CANCEL);
            ButtonType result = alert.getResult();
            if (result == ButtonType.OK) {
                ProjectManager.getInstance().deleteProject();
            }
        }
    }
}
