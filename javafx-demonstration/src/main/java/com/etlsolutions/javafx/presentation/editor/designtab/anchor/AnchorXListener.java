package com.etlsolutions.javafx.presentation.editor.designtab.anchor;

import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author ZhipengChang
 */
public class AnchorXListener implements ChangeListener<Number> {

    private final GwisePoint point;

    public AnchorXListener(GwisePoint point) {
        this.point = point;
    }
    
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        point.setX(newValue.doubleValue());
    }
    
}
