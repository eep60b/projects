package com.etlsolutions.javafx;

import com.etlsolutions.javafx.system.CustomLevelWarningRuntimeExceiption;
import com.etlsolutions.javafx.system.GwiseRepository;
import com.etlsolutions.javafx.system.ThrowableHandler;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import static javafx.application.Application.launch;

/**
 * The MainApp class contains methods to start the application.
 *
 * @author zc
 */
public class MainApp extends Application {

    /**
     * This method will be called automatically by JavaFX after the main()
     * method.
     */
    @Override
    public void init() {
        try {
            GwiseRepository.getInstance().initRepository();
        } catch (IOException ex) {
            ThrowableHandler.getInstance().handleError(ex, MainApp.class);
        }
    }

    /**
     * This method will be called automatically by JavaFX after the main()
     * method.
     *
     * @param stage
     */
    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void start(Stage stage) {

        try {
            Logger.getLogger(MainApp.class).info("Start the applicaiton");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("ETL JavaFX POC");
            stage.setScene(scene);
            stage.show();
        } catch (CustomLevelWarningRuntimeExceiption ex) {
            ThrowableHandler.getInstance().handleWarning(ex, MainApp.class);
        } catch (Throwable th) {
            ThrowableHandler.getInstance().handleError(th, MainApp.class);
        }
    }

    @Override
    public void stop() {
        //By default this does nothing
        //It runs if the user clicks the go-away button
        //closing the window or if Platform.exit() is called.
        //Use Platform.exit() instead of System.exit(0).
        //This is where you should offer to save any unsaved
        //stuff that the user may have generated.
    }

    /**
     * The main() method is ignored in a correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
