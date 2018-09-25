package com.etlsolutions.javafx.presentation.wizard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 */
public class WizardFinishEventHandler implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        
        Button button = (Button) event.getSource();        
        Wizard w = (Wizard) button.getParent().getParent();        
        w.finish();
    }
    
}
