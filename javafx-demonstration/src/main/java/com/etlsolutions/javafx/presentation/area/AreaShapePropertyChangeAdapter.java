package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class AreaShapePropertyChangeAdapter implements PropertyChangeListener {

    private final NodeGenerator nodeGenerator;
    private final Tab measurementTab;


    public AreaShapePropertyChangeAdapter(NodeGenerator nodeGenerator, Tab measurementTab) {
        this.nodeGenerator = nodeGenerator;
        this.measurementTab = measurementTab;
    }   

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<MeasurementType> wrapper = (ValueWrapper<MeasurementType>) evt.getSource();
        
        measurementTab.setContent(nodeGenerator.getNode(wrapper.getValue()));
    }
}
