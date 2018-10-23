package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class SubAreaShapeChangeAdapter implements ChangeListener<SubAreaShape> {

    private final AbstractAreaDefinedSubAreaDataModel model;
    private final Tab measurementTab;
    private final Map<SubAreaShape, Node> map;

    public SubAreaShapeChangeAdapter(AbstractAreaDefinedSubAreaDataModel model, Tab measurementTab, Map<SubAreaShape, Node> map) {
        this.model = model;
        this.measurementTab = measurementTab;
        this.map = map;
    }

    @Override
    public void changed(ObservableValue<? extends SubAreaShape> observable, SubAreaShape oldValue, SubAreaShape newValue) {
        model.setSelectedSubAreaShape(newValue);
        measurementTab.setContent(map.get(newValue));
    }
}
