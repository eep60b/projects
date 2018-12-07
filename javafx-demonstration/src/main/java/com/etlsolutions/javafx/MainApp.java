package com.etlsolutions.javafx;

import com.etlsolutions.javafx.system.GwiseRepository;
import com.etlsolutions.javafx.system.ThrowableHandler;
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
        } catch (Throwable th) {
            ThrowableHandler.getInstance().handle(th, getClass());
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {

        try {
            GwiseRepository.getInstance().initRepository(args);
            launch(args);
        } catch (Throwable th) {
            ThrowableHandler.getInstance().handle(th, MainApp.class);
        }
    }
}
