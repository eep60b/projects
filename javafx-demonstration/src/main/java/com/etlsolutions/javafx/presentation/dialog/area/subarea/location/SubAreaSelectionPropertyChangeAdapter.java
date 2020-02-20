package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author zc
 */
public class SubAreaSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private final ObservableListWrapperA<LocationType> types;
    private final ValueWrapper<LocationType> locationTypeValueWrapper;
    
    public SubAreaSelectionPropertyChangeAdapter( ObservableListWrapperA<LocationType> types, ValueWrapper<LocationType> locationTypeValueWrapper) {
        this.types = types;
        this.locationTypeValueWrapper = locationTypeValueWrapper;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<SubArea> wrapper = (ValueWrapper<SubArea>)evt.getSource();
        
        types.clear();
        SubArea subArea = wrapper.getValue();
        if(subArea == null) {
            locationTypeValueWrapper.setValue(null);
            return;
        }
        
        types.addAll(subArea.getLocationTypes());
        
        if(types.contains(locationTypeValueWrapper.getValue())) {
            return;
        }
        
        locationTypeValueWrapper.setValue(subArea.getLocationTypes().get(0));
    }

}
