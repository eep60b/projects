package com.etlsolutions.javafx.presentation.dialog.fertiliser;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.other.FertiliserType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 *
 * @author zc
 */
public class TypePropertyChangeAdapter implements PropertyChangeListener {

    private final Map<FertiliserType, Node> map;
    private final Tab tab;

    public TypePropertyChangeAdapter(Map<FertiliserType, Node> map, Tab tab) {
        this.map = map;
        this.tab = tab;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        FertiliserType type = ((ValueWrapper<FertiliserType>) evt.getSource()).getValue();        
        tab.setContent(map.get(type));
    }
    
}
