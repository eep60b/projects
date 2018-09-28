package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.DateTimePicker;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class AlivePropertyChangeAdapter implements PropertyChangeListener {

    private final DateTimePicker terminationDatePicker;
    private final TextArea terminationTextArea;

    public AlivePropertyChangeAdapter(DateTimePicker terminationDatePicker, TextArea terminationTextArea) {
        this.terminationDatePicker = terminationDatePicker;
        this.terminationTextArea = terminationTextArea;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AddPlantsDataModel model = (AddPlantsDataModel) evt.getSource();
        boolean isAlive = model.isAlive();
        if(!isAlive){
            terminationDatePicker.setDateTimeValue(LocalDateTime.now());
            terminationTextArea.setText("");
        }
        
        terminationDatePicker.setVisible(!isAlive);
        terminationTextArea.setVisible(!isAlive);
    }

}
