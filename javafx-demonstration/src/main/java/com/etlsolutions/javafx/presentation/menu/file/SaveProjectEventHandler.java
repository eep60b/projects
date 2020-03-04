package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.gwise.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class SaveProjectEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ProjectManager.getInstance().saveProject();
    }
}
