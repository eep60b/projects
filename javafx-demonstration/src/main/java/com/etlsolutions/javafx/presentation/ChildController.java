package com.etlsolutions.javafx.presentation;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author zc
 * @param <T>
 */
public interface ChildController<T> extends Initializable {
        
    /**
     * 
     * @param parentModel 
     */
     void setParentModel(T parentModel);
     
     void setParentStage(Stage parentStage);
}
