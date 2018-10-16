package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.AbstractFXMLController;
import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class AbstractComponentsFXMLController<T> extends AbstractFXMLController {

    protected Stage stage;
    protected T model;
    
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
