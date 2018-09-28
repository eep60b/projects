package com.etlsolutions.javafx.presentation;

import java.time.LocalDate;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

/**
 *
 * @author zc
 */
public class CurrentMaxDayCellFactory implements Callback<DatePicker, DateCell> {

    @Override
    public DateCell call(DatePicker datePicker) {
        
       return  new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (item.isAfter(LocalDate.now())) { //Disable all dates after required date
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;"); //To set background on different color
                }
            }
        };
    }
}
