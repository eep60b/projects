package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author zc
 */
public class AreaSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private final ObservableListWrapperA<SubArea> children;
    private final ValueWrapper<SubArea> selectedChildWrapper;
    


    public AreaSelectionPropertyChangeAdapter(ObservableListWrapperA<SubArea> children, ValueWrapper<SubArea> selectedChildWrapper) {
    
    this.children = children;
    this.selectedChildWrapper = selectedChildWrapper;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ValueWrapper<Area> wrapper = (ValueWrapper<Area>) evt.getSource();
        children.clear();
        children.addAll(wrapper.getValue().getSubAreas());
        SubArea subArea = selectedChildWrapper.getValue();
        if(children.contains(subArea)) {
            return;
        }
        selectedChildWrapper.setValue(children.isEmpty() ? null : children.get(0));
    }  
}
