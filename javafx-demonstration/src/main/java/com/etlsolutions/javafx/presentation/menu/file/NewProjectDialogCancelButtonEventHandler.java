package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.presentation.StageManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class NewProjectDialogCancelButtonEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        StageManager.getInstance().closeAndRemove(StageManager.NEW_PROJECT_DIALOG_STAGE);
    }    
}
