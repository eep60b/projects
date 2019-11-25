package com.etlsolutions.javafx.presentation.editor.designtab.anchor;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;

/**
 *
 * @author ZhipengChang
 */
public class AnchorDoubleProperty extends SimpleDoubleProperty {


    private ChangeListener<? super Number> listener;

    public AnchorDoubleProperty(Anchor anchor, String name) {
        super(anchor, name);
    }
    
    @Override
    public void addListener(ChangeListener<? super Number> listener) {
        this.listener = listener;
        super.addListener(listener);
    }

    public void removeListener() {
        if (listener != null) {
            removeListener(listener);
        }
    }
}
