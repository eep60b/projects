package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.StageManager;
import static com.etlsolutions.javafx.presentation.StageManager.ADD_PLANT_VARIETY_DIALOG_STAGE;
import com.etlsolutions.javafx.presentation.menu.add.planttype.PlantTypeDialogDataModel;
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
 * @param <T>
 */
public class AddPlantVarietyEventHandler<T>  implements EventHandler<ActionEvent> {

    private final PlantTypeDialogDataModel model;

    public AddPlantVarietyEventHandler(PlantTypeDialogDataModel model) {
        this.model = model;
    }
    
    @Override
    public void handle(ActionEvent event) {

        Logger logger = Logger.getLogger(getClass());
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu/add/AddPlantVarietyDialogFXML.fxml"));
            Parent root = loader.load();
            AddPlantVarietyDialogFXMLController controller = loader.getController();
            controller.setParentModel(model);
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            StageManager.getInstance().putStage(ADD_PLANT_VARIETY_DIALOG_STAGE, stage);
            stage.setTitle("Add Plant Variety");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            String message = "Failed to create new plant variety.";
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}