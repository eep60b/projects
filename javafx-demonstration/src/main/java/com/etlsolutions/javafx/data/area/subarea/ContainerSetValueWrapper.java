package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.Container;

/**
 *
 * @author zc
 */
public class ContainerSetValueWrapper implements SubAreaValueWrapper {

    private final ValueWrapper<Container> containerValueWrapper;

    public ContainerSetValueWrapper(Container container) {
        this.containerValueWrapper = new ValueWrapper<>(container);
    }

    public ValueWrapper<Container> getContainerValueWrapper() {
        return containerValueWrapper;
    }
}
