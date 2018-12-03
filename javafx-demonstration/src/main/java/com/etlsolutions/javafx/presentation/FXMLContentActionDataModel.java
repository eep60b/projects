package com.etlsolutions.javafx.presentation;

/**
 *
 * @author zc
 */
public interface FXMLContentActionDataModel extends FXMLActionDataModel {
    
    FXMLActionDataModel getContentModel();
    
    void setContentModel(FXMLActionDataModel model);
}
