package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.gwise.system.ProjectConfiguration;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author zc
 */
public class OpenProjectEventHandler extends FXMLActionEventHandler<OpenProjectDataModel> {

    public OpenProjectEventHandler(OpenProjectDataModel model) {
        super(model);
    }
    
    @Override
    public void handle(ActionEvent event) {
        ProjectConfiguration c = ProjectManager.getInstance().getConfiguration();

        if (c != null && c.getModified().getValue()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to save change for the current project?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            ButtonType result = alert.getResult();
            if (result == ButtonType.YES) {
                ProjectManager.getInstance().saveProject();
            } else if (result == ButtonType.CANCEL) {
                return;
            }
        }

        super.handle(event);
    }
    
}
