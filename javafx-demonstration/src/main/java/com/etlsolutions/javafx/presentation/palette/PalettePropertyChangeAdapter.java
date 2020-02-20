package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.gwise.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author zc
 */
public class PalettePropertyChangeAdapter implements PropertyChangeListener {

    private final AnchorPane paletteAnchorPane;

    public PalettePropertyChangeAdapter(AnchorPane paletteAnchorPane) {
        this.paletteAnchorPane = paletteAnchorPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<Tab> wrapper = (ValueWrapper<Tab>)evt.getSource();
        paletteAnchorPane.setVisible(wrapper.getValue() != null);
    }
}
