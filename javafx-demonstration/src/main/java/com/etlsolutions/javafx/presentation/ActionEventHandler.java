package com.etlsolutions.javafx.presentation;

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
public abstract class ActionEventHandler<T> implements EventHandler<ActionEvent> {

    private final T parentModel;

    public ActionEventHandler(T parentModel) {
        this.parentModel = parentModel;
    }

    public abstract String getFxmlFilePath();
    public abstract String getStageTitle();
    public abstract String getErrorMessage();
    
    @Override
    public void handle(ActionEvent event) {
        Logger logger = Logger.getLogger(getClass());
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(getFxmlFilePath()));
            Parent root = loader.load();
            ChildController controller = loader.getController();
            controller.setParent(parentModel);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(getStageTitle());
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            String message = getErrorMessage();
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}
