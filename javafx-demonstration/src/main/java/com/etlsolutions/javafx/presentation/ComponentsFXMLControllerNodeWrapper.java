package com.etlsolutions.javafx.presentation;

import javafx.scene.Node;

/**
 *
 * @author zc
 * @param <T>
 */
public class ComponentsFXMLControllerNodeWrapper<T> {
    
    private final AbstractComponentsFXMLController<T> controller;
    private final Node node;

    public ComponentsFXMLControllerNodeWrapper(AbstractComponentsFXMLController<T> controller, Node node) {
        this.controller = controller;
        this.node = node;
    }

    public AbstractComponentsFXMLController<T> getController() {
        return controller;
    }

    public Node getNode() {
        return node;
    }
    
}
