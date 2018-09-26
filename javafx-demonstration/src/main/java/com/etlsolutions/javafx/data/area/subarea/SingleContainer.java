package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;

/**
 *
 * @author zc
 */
public class SingleContainer extends SubAreaK {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
