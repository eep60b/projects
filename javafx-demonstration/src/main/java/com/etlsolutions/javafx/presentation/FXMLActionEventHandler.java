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
 * The DialogActionEventHandler class is a universal event handler which starts
 * a new dialog. It will load the FXML file path, the dialog title and the
 * exception message from the bundle files
 * (com/etlsolutions/javafx/presentation/AcitionEvent_*.properties) which use
 * the full class name of the data model as the key.
 *
 * Usages:
 *
 * 1. Create a data model class.
 *
 * 2. Create an FXML file with a new controller which extends
 * AbstractFXMLController with the data model as its T type.
 * 
 * 3. Add an entry to the bundle file with the full data model class name as the key.
 *
 * @author zc
 * @param <T>
 */
public class FXMLActionEventHandler<T extends FXMLActionDataModel> implements EventHandler<ActionEvent> {

    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ACTION_EVENT_BUNDLE_PATH);

    protected final T model;

    public FXMLActionEventHandler(T model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        Logger logger = Logger.getLogger(getClass());
        String message = "Message has NOT been loaded from the bundle.";
        try {

            String[] strs = BUNDLE.getString(model.getClass().getName()).split(BUNDLE_SEPARATER);
            message = strs[1];
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getFxmlPath()));
            Parent root = loader.load();
            AbstractComponentsFXMLController<T> controller = loader.getController();
            controller.setModel(model);
            controller.setStage(stage);
            controller.initializeComponents();

            Scene scene = new Scene(root);
            stage.setTitle(strs[0]);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            logger.error(message, ex);
            throw new CustomLevelErrorRuntimeExceiption(message);
        }
    }
}
