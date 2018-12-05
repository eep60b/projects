package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.presentation.StageManager;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class NewProjectDialogOkButtonEventHandler implements EventHandler<ActionEvent> {

    private final NewProjectDialogDataModel model;

    public NewProjectDialogOkButtonEventHandler(NewProjectDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        ProjectManager.getInstance().createProject(model.getPathValueWrapper().getValue(), model.getNameValueWrapper().getValue());
        StageManager.getInstance().closeAndRemove(StageManager.NEW_PROJECT_DIALOG_STAGE);
    }
}
