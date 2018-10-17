package com.etlsolutions.javafx.presentation.area;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
public class AreaShapeValuePropertyChangeAdapter implements PropertyChangeListener {

    private final TextField areaTextField;

    public AreaShapeValuePropertyChangeAdapter(TextField areaTextField) {
        this.areaTextField = areaTextField;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddAreaDataModel model = (AddAreaDataModel) evt.getSource();
       areaTextField.setText(String.valueOf(model.getAreaValue()));
    }
    
}
