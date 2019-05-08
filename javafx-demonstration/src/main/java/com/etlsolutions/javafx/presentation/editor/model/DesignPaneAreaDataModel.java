package com.etlsolutions.javafx.presentation.editor.model;

import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author ZhipengChang
 */
public class DesignPaneAreaDataModel {
    
    private final ObservableListWrapperA<DesignPaneSubAreaDataModel> subAreas = new ObservableListWrapperA<>();
    
    private DesignPaneSubAreaDataModel enlightenedSubArea;
    
    
    public ObservableListWrapperA<DesignPaneSubAreaDataModel> getSubAreas() {
        return subAreas;
    }        
}
