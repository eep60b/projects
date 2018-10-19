package com.etlsolutions.javafx.presentation.area;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
public class AreaValuePropertyChangeAdapter implements PropertyChangeListener {

    private final TextField areaTextField;

    public AreaValuePropertyChangeAdapter(TextField areaTextField) {
        this.areaTextField = areaTextField;
    }

    public AreaValuePropertyChangeAdapter(Tab measurementTab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AreaValueDataModel model = (AreaValueDataModel) evt.getSource();
       areaTextField.setText(String.valueOf(model.getAreaValue()));
    }
    
}
