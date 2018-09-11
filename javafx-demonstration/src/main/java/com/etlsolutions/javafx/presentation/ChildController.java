package com.etlsolutions.javafx.presentation;

import javafx.fxml.Initializable;

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
     void setParent(T parentModel);
}
