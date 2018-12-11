package com.etlsolutions.javafx.presentation.menu.file;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class NewProjectDialogBrowseButtonEventHandler implements EventHandler<ActionEvent> {

    private final Label label;

    public NewProjectDialogBrowseButtonEventHandler(Label label) {
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File f = directoryChooser.showDialog(new Stage());
        if (f == null) {
            return;
        }
        label.setText(f.getAbsolutePath());
    }

}
