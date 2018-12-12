package com.etlsolutions.javafx.system;

import javafx.scene.control.Alert;
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

    public void handleWarning(CustomLevelWarningRuntimeExceiption ex, Class<?> klass) {
        Logger.getLogger(klass).warn(ex);
        Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
        alert.showAndWait();
    }      
    
    public void handleError(Throwable th, Class<?> klass, String message) {
        Logger.getLogger(klass).error(th);
        th.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
        System.exit(-1);
    }    
    
    public void handleError(Throwable th, Class<?> klass) {
        
        handleError(th, klass, "Error: the project is corrupted.");
    }
}
