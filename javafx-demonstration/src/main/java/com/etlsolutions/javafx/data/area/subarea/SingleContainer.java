package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;

/**
 *
 * @author zc
 */
public class SingleContainer extends SubArea {

    private Container container;
    
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
        setTitle(this.container.getTitle());
        setInformation(this.container.getInformation());
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.SINGLE_CONTAINTER;
    }

    @Override
    public void updateAllLocations() {
        allLocations.clear();
        allLocations.add(container);
    }
}
