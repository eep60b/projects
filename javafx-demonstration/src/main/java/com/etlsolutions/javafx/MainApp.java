package com.etlsolutions.javafx;

import com.etlsolutions.javafx.system.ConfigurationUtils;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 * The MainApp class contains methods to start the application.
 *
 * @author zc
 */
public class MainApp extends Application {

    @Override
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
            Logger.getLogger(MainApp.class).error(th);
            JOptionPane.showMessageDialog(null, "Error: the project is corrupted.");
            System.exit(-1);
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through deployment artifacts, e.g., in IDEs
     * with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConfigurationUtils.initRepository(args);
            launch(args);
        } catch (Throwable th) {
            Logger.getLogger(MainApp.class).error(th);
            JOptionPane.showMessageDialog(null, "Error: the project is corrupted.");
            System.exit(-1);
        }
    }
}