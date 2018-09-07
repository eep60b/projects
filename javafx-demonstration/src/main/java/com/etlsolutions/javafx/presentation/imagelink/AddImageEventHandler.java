package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.system.SettingConstants;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
class AddImageEventHandler implements EventHandler<ActionEvent> {

    private final AddImageDataModel model;
    private final Stage ownerStage;

    AddImageEventHandler(AddImageDataModel model, Stage ownerStage) {
        this.model = model;
        this.ownerStage = ownerStage;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Image");
        File defaultDirectory = getDirectory(new File(SettingConstants.DEFAULT_IMAGE_DIRECTORY));
        chooser.setInitialDirectory(defaultDirectory);
        
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image files", "jpeg", "exif", "tiff", "gif", "bmp", "png"));

        File selectedFile = chooser.showOpenDialog(ownerStage);
        if (selectedFile != null) {
            model.setImageFileLink(selectedFile.getAbsolutePath());
        }
    }

    private File getDirectory(File file) {

        if (file.isDirectory()) {
            return file;
        }

        return getDirectory(file.getParentFile());
    }
}
