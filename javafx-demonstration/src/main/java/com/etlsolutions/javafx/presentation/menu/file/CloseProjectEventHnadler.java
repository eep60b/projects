package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author zc
 */
public class CloseProjectEventHnadler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        if (ProjectManager.getInstance().getProject().isModified()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to save the changes?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            ButtonType result = alert.getResult();
            if (result == ButtonType.YES) {
                ProjectManager.getInstance().saveProject();
            } else if (result == ButtonType.CANCEL) {
                return;
            }
        }
        ProjectManager.getInstance().close();
    }
}
