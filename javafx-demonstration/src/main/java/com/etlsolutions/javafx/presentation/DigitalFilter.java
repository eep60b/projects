package com.etlsolutions.javafx.presentation;

import java.util.function.UnaryOperator;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter.Change;

/**
 *
 * @author zc
 */
public class DigitalFilter implements UnaryOperator<Change> {

    @Override
    public Change apply(Change change) {
        
        String text = ((TextField) change.getControl()).getText() + change.getText();
        if (text == null || text.trim().isEmpty() || text.trim().matches("\\d+") || text.trim().matches("^\\d*\\.\\d+|\\d+\\.\\d*$")) {
            return change;
        } 
        return null;
    }
}
