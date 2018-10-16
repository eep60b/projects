package com.etlsolutions.javafx.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class AbstractComponentsFXMLController<T> {

    protected Stage stage;
    protected T model;
    
    public abstract void initializeComponents();    
    
    /**
     * 
     * @param model 
     */
     public final void setModel(T model) {
         this.model = model;
     }
     
     public final void setStage(Stage stage) {
         this.stage = stage;
     }
}
