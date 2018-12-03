package com.etlsolutions.javafx.presentation;

import javafx.scene.Node;

/**
 *
 * @author zc
 */
public class NodeWrapper {
    
    private final Object model;
    private final Node node;

    public NodeWrapper(Object model, Node node) {
        this.model = model;
        this.node = node;
    }

    public Object getModel() {
        return model;
    }

    public Node getNode() {
        return node;
    }    
}
