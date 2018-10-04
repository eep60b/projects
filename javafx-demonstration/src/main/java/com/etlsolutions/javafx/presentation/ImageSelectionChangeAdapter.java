package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 */
public class ImageSelectionChangeAdapter implements PropertyChangeListener {

    private final Button removeImageButton;
    private final Button editImageButton;
    private final Button moveToBeginImageButton;
    private final Button moveToLeftImageButton;
    private final Button moveToRightImageButton;
    private final Button moveToEndImageButton;

    public ImageSelectionChangeAdapter(Button removeImageButton, Button editImageButton, Button moveToBeginImageButton, Button moveToLeftImageButton, Button moveToRightImageButton, Button moveToEndImageButton) {

        this.removeImageButton = removeImageButton;
        this.editImageButton = editImageButton;
        this.moveToBeginImageButton = moveToBeginImageButton;
        this.moveToLeftImageButton = moveToLeftImageButton;
        this.moveToRightImageButton = moveToRightImageButton;
        this.moveToEndImageButton = moveToEndImageButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        DataUnitDataModel model = (DataUnitDataModel) evt.getSource();
        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);
        editImageButton.setDisable(selectedImageLink == null);
        moveToBeginImageButton.setDisable(model.isFirstImage());
        moveToLeftImageButton.setDisable(model.isFirstImage());
        moveToEndImageButton.setDisable(model.isLastImage());
        moveToRightImageButton.setDisable(model.isLastImage());
    }

}
