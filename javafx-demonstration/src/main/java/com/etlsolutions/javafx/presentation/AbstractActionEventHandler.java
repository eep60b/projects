package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import static com.etlsolutions.javafx.system.SettingConstants.*;
import java.io.IOException;
import java.util.ResourceBundle;
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
public class AbstractActionEventHandler<T> implements EventHandler<ActionEvent> {

    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ACTION_EVENT_BUNDLE_PATH);
    
    protected final T model;

    public AbstractActionEventHandler(T model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        Logger logger = Logger.getLogger(getClass());
        String message = "Message has NOT been loaded from the bundle.";
        try {
            
            String[] strs = BUNDLE.getString(model.getClass().getName()).split(BUNDLE_SEPARATER);
            message = strs[2];
            Stage stage = new Stage();            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(strs[0]));
            Parent root = loader.load();
            AbstractFXMLController<T> controller = loader.getController();
            controller.setModel(model);
            controller.setStage(stage);
            controller.initializeComponents();
            
            Scene scene = new Scene(root);
            stage.setTitle(strs[1]);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {          
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}
