package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 *
 * @author zc
 */
public class BooleanValueNodeChangeAdapter implements ChangeListener<Boolean> {

    private final ValueWrapper<String> value;
    private final Node[] nodes;

    public BooleanValueNodeChangeAdapter(ValueWrapper<String> value, Node... nodes) {

        this.value = value;
        this.nodes = nodes;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

        if (!newValue) {
            value.setValue(String.valueOf(0));
        }

        for (Node node : nodes) {
            node.setVisible(newValue);
        }
    }

}
