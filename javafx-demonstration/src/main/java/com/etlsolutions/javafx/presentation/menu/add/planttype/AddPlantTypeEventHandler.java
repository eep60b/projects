package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.io.IOException;
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
public class AddPlantTypeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Logger logger = Logger.getLogger(getClass());
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu/add/AddPlantTypeDialogFXML.fxml"));
            Parent root = loader.load();
            AddPlantTypeDialogFXMLController controller = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            controller.setStage(stage);
            stage.setTitle("Add Plant Type");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            String message = "Failed to create new plant type.";
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}
