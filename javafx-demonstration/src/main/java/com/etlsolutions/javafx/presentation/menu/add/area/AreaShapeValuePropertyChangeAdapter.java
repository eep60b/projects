package com.etlsolutions.javafx.presentation.menu.add.area;

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
        
        AddAreaDialogDataModel model = (AddAreaDialogDataModel) evt.getSource();
       areaTextField.setText(String.valueOf(model.getAreaValue()));
    }
    
}
