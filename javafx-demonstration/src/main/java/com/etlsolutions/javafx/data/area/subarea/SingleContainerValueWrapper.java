/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Container;

/**
 *
 * @author zc
 */
public class SingleContainerValueWrapper implements SubAreaValueWrapper {

    private final ValueWrapper<Container> containerValueWrapper;

    public SingleContainerValueWrapper(Container container) {
        this.containerValueWrapper = new ValueWrapper<>(container);
    }

    public ValueWrapper<Container> getContainerValueWrapper() {
        return containerValueWrapper;
    }
}