package com.etlsolutions.javafx.presentation.menu.file;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class NewProjectDialogBrowseButtonEventHandler implements EventHandler<ActionEvent> {

    private final TextField pathTextField;

    public NewProjectDialogBrowseButtonEventHandler(TextField pathTextField) {
        this.pathTextField = pathTextField;
    }

    @Override
    public void handle(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File f = directoryChooser.showDialog(new Stage());
        if (f == null) {
            return;
        }
        pathTextField.setText(f.getAbsolutePath());
    }

}
