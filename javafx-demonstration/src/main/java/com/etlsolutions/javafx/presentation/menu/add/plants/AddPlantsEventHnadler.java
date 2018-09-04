package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.StageManager;
import static com.etlsolutions.javafx.presentation.StageManager.ADD_PLANTS_DIALOG_STAGE;
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
public class AddPlantsEventHnadler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Logger logger = Logger.getLogger(getClass());
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu/add/AddPlantsDialogFXML.fxml"));
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            StageManager.getInstance().putStage(ADD_PLANTS_DIALOG_STAGE, stage);
            stage.setTitle("Add Plants");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            logger.error("Failed to add plants", ex);
            throw new CustomLevelErrorRuntimeExceiption("Failed to create add plants.");
        }
    }
}
