package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.data.PropertyChangeAdapter;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author zc
 */
public class PalettePropertyChangeAdapter extends PropertyChangeAdapter<AnchorPane> {

    public PalettePropertyChangeAdapter(AnchorPane paletteAnchorPane) {
        super(paletteAnchorPane);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<Tab> wrapper = (ValueWrapper<Tab>)evt.getSource();
        source.setVisible(wrapper.getValue() != null);
    }
}
