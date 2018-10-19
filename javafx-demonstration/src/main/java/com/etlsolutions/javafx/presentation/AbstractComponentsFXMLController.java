package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class AbstractComponentsFXMLController<T> {

    protected T model;
    
    public abstract void initializeComponents();    
    
    /**
     * 
     * @param model 
     */
     public final void setModel(T model) {
         this.model = model;
     }
}
