package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.StageManager;
import static com.etlsolutions.javafx.presentation.StageManager.ADD_PLANT_TYPE_DIALOG_STAGE;
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
public class AddImageLinkEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitDataModel parentModel;

    public AddImageLinkEventHandler(DataUnitDataModel parentModel) {
        this.parentModel = parentModel;
    }

    @Override
    public void handle(ActionEvent event) {
        
        Logger logger = Logger.getLogger(getClass());
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/imagelink/AddImageLinkDialogFXML.fxml"));
            
            AddImageLinkDialogFXMLController controller = loader.getController();
            
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            StageManager.getInstance().putStage(ADD_PLANT_TYPE_DIALOG_STAGE, stage);
            stage.setTitle("Add Image");
            stage.setScene(scene);
            controller.setOwnerWindow(stage);
            controller.setParentModel(parentModel);
            stage.show();
        } catch (IOException ex) {
            String message = "Failed to create new imagee.";
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}