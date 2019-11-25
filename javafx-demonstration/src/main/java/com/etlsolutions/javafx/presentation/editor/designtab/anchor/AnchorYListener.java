package com.etlsolutions.javafx.presentation.editor.designtab.anchor;

import com.etlsolutions.javafx.data.basicshape.GwisePoint;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author ZhipengChang
 */
public class AnchorYListener implements ChangeListener<Number>{

    private final GwisePoint point;

    public AnchorYListener(GwisePoint point) {
        this.point = point;
    }
    
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        point.setY(newValue.doubleValue());
    }
    
}
