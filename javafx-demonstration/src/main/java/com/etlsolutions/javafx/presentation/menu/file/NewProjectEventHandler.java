package com.etlsolutions.javafx.presentation.menu.file;

import java.io.IOException;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class NewProjectEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu/file/NewProjectDialigFXML.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/menu/file/newprojectDialigfxml.css");

            Stage stage = new Stage();
            stage.setTitle("New Project");
            stage.setScene(scene);
            stage.show();
            Logger.getLogger(getClass()).info("Create a new project:");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(NewProjectEventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
