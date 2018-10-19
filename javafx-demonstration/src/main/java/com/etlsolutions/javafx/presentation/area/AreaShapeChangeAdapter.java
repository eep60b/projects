package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class AreaShapeChangeAdapter implements ChangeListener<AreaShape> {

    private final AbstractAreaDataModel model;
    private final Tab measurementTab;
    private final Map<AreaShape, Node> map;

    public AreaShapeChangeAdapter(AbstractAreaDataModel model, Tab measurementTab, Map<AreaShape, Node> map) {
        this.model = model;
        this.measurementTab = measurementTab;
        this.map = map;
    }

    @Override
    public void changed(ObservableValue<? extends AreaShape> observable, AreaShape oldValue, AreaShape newValue) {

        if (oldValue == newValue) {
            return;
        }
        
        model.setSelectedAreaShape(newValue);
        measurementTab.setContent(map.get(newValue));
    }
}
