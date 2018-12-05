package com.etlsolutions.javafx.presentation.menu.file;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class NewProjectDialogBrowseButtonEventHandler implements EventHandler<ActionEvent> {

    private final NewProjectDialogDataModel model;

    public NewProjectDialogBrowseButtonEventHandler(NewProjectDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File f = fileChooser.showOpenDialog(new Stage());
        if (f == null) {
            return;
        }
        model.getPathValueWrapper().setValue(f.getAbsolutePath());
    }

}
