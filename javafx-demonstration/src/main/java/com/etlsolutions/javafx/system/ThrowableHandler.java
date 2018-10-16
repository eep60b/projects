package com.etlsolutions.javafx.system;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class ThrowableHandler {

    private static final ThrowableHandler INSTANCE = new ThrowableHandler();

    private ThrowableHandler() {
    }

    public static ThrowableHandler getInstance() {
        return INSTANCE;
    }

    public void handle(Throwable th, Class<?> klass) {
        Logger.getLogger(klass).error(th);
        Alert alert = new Alert(Alert.AlertType.ERROR, "Error: the project is corrupted.", ButtonType.CLOSE);
        alert.showAndWait();
        System.exit(-1);
    }
}
