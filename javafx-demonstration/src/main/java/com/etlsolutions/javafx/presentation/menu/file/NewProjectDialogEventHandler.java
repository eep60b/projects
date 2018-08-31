package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.presentation.StageManager;
import static com.etlsolutions.javafx.presentation.StageManager.NEW_PROJECT_DIALOG_STAGE;
import com.etlsolutions.javafx.system.ProjectManager;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class NewProjectDialogEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Logger logger = Logger.getLogger(getClass());

        try {

            if (ProjectManager.getInstance().getProject().isModified()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to save change for the current project?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                ButtonType result = alert.getResult();
                if (result == ButtonType.YES) {
                    ProjectManager.getInstance().saveProject();
                } else if (result == ButtonType.CANCEL) {
                    return;
                }
            }

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu/file/NewProjectDialigFXML.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/menu/file/newprojectDialigfxml.css");

            Stage stage = new Stage();
            StageManager.getInstance().putStage(NEW_PROJECT_DIALOG_STAGE, stage);
            stage.setTitle("New Project");
            stage.setScene(scene);
            stage.show();
            logger.info("Create a new project:");
        } catch (IOException ex) {
            logger.error("Failed to create new project", ex);
            throw new CustomLevelErrorRuntimeExceiption("Failed to create new project.");
        }
    }

}
