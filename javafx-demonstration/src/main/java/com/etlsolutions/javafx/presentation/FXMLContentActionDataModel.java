package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 * @param <M>
 */
public interface FXMLContentActionDataModel extends FXMLActionDataModel {
    
    Object getContentModel();
    
    void setContentModel(Object model);
}
