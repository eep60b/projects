package com.etlsolutions.javafx.presentation;

import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter.Change;

/**
 *
 * @author zc
 */
public class DigitalFilter implements UnaryOperator<Change> {

    @Override
    public Change apply(Change change) {
        String text = change.getText();
        if (text.matches("^[-+]?\\d+(\\.\\d+)?$")) {
            return change;
        }
        return null;
    }
}
