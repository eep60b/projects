package com.etlsolutions.javafx.presentation;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public interface FxmlControllable<T> extends Initializable {
        
    /**
     * 
     * @param model 
     */
     void setModel(T model);
     
     void setStage(Stage starge);
}
