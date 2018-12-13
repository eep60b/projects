package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class AreaShapePropertyChangeAdapter implements PropertyChangeListener {

    private final FXMLContentActionDataModel model;
    private final NodeGenerator nodeGenerator;
    private final Tab measurementTab;


    public AreaShapePropertyChangeAdapter(FXMLContentActionDataModel model, NodeGenerator nodeGenerator, Tab measurementTab) {
        this.model = model;
        this.nodeGenerator = nodeGenerator;
        this.measurementTab = measurementTab;
    }   

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<MeasurementType> wrapper = (ValueWrapper<MeasurementType>) evt.getSource();
        model.setContentModel(MeasurementDataModelGenerator.getInstance().getMeasurementDataModel(wrapper.getValue()));
        measurementTab.setContent(nodeGenerator.getNode(wrapper.getValue()));
    }
}
