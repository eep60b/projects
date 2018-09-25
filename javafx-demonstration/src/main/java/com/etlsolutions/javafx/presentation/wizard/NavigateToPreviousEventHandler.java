/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.wizard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 */
public class NavigateToPreviousEventHandler implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();
        
        Wizard w = (Wizard) button.getParent().getParent();
        
        w.previousPage();
    }
    
}
