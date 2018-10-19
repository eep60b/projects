package com.etlsolutions.javafx.presentation;

import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class AbstractComponentStageFXMLController<T> extends AbstractComponentsFXMLController<T>{

    protected Stage stage;
    
  
     public final void setStage(Stage stage) {
         this.stage = stage;
     }
}
