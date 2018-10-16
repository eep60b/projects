package com.etlsolutions.javafx;

import com.etlsolutions.javafx.system.ThrowableHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author zc
 */
public abstract class AbstractFXMLController implements Initializable {

    public abstract void initializeComponents();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    @SuppressWarnings("UseSpecificCatch")
    public final void initialize(URL url, ResourceBundle rb) {
        try {
            initializeComponents();
        } catch (Throwable th) {
            ThrowableHandler.getInstance().handle(th, getClass());
        }
    }

}
