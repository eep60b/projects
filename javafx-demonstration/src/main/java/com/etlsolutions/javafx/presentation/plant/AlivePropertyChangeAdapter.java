package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author zc
 */
public class AlivePropertyChangeAdapter implements PropertyChangeListener {

    private final DateTimePicker terminationDatePicker;
    private final TextArea terminationTextArea;
    private final Label[] labels;

    public AlivePropertyChangeAdapter(DateTimePicker terminationDatePicker, TextArea terminationTextArea, Label... labels) {
        this.terminationDatePicker = terminationDatePicker;
        this.terminationTextArea = terminationTextArea;
        this.labels = labels;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ValueWrapper<Boolean> model = (ValueWrapper<Boolean>) evt.getSource();
        boolean isAlive = model.getValue();
        if(!isAlive){
            terminationDatePicker.setDateTimeValue(LocalDateTime.now());
            terminationTextArea.setText("");
        }
        
        terminationDatePicker.setVisible(!isAlive);
        terminationTextArea.setVisible(!isAlive);
        for(Label label : labels) {
            label.setVisible(!isAlive);
        }
    }

}
