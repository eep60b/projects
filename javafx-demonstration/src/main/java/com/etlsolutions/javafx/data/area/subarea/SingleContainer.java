package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.CONTAINER);
    }  
}
