package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.presentation.FXMLActionDataModel;

/**
 *
 * @author zc
 * @param <T>
 */
public interface FXMLContentActionDataModel<T extends FXMLActionDataModel> extends FXMLActionDataModel {
    
    T getContentModel();
    
    void setContentModel(T model);
}
