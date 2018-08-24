package com.etlsolutions.javafx.presentation.menu.file;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class NewProjectEventHandler implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Logger.getLogger(getClass()).info("Create a new project:");
    }
    
}
