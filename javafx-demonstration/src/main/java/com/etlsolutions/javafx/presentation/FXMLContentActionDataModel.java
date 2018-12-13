package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 * @param <T>
 */
public interface FXMLContentActionDataModel<T extends FXMLActionDataModel> extends FXMLActionDataModel {
    
    T getContentModel();
    
    void setContentModel(T model);
}
