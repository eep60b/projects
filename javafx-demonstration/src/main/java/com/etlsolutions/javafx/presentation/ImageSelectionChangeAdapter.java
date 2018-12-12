package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 * @param <D>
 */
public class ImageSelectionChangeAdapter<D extends DataUnit> implements PropertyChangeListener {

    private final DataUnitFXMLDataModel<D> model;    
    private final Button removeImageButton;
    private final Button editImageButton;
    private final Button moveToBeginImageButton;
    private final Button moveToLeftImageButton;
    private final Button moveToRightImageButton;
    private final Button moveToEndImageButton;

    public ImageSelectionChangeAdapter(DataUnitFXMLDataModel<D> model, Button removeImageButton, Button editImageButton, Button moveToBeginImageButton, Button moveToLeftImageButton, Button moveToRightImageButton, Button moveToEndImageButton) {
        
        this.model = model;
        this.removeImageButton = removeImageButton;
        this.editImageButton = editImageButton;
        this.moveToBeginImageButton = moveToBeginImageButton;
        this.moveToLeftImageButton = moveToLeftImageButton;
        this.moveToRightImageButton = moveToRightImageButton;
        this.moveToEndImageButton = moveToEndImageButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ImageLink selectedImageLink = model.getSelectedImageLinkWrapper().getValue();
        removeImageButton.setDisable(selectedImageLink == null);
        editImageButton.setDisable(selectedImageLink == null);
        moveToBeginImageButton.setDisable(model.getSelectedImgLinkIndex() < 1);
        moveToLeftImageButton.setDisable(model.getSelectedImgLinkIndex() < 1);
        moveToEndImageButton.setDisable(model.getSelectedImgLinkIndex() < 1 || model.getSelectedImgLinkIndex() == model.getImageLinks().size() - 1);
        moveToRightImageButton.setDisable(model.getSelectedImgLinkIndex() < 1 || model.getSelectedImgLinkIndex() == model.getImageLinks().size() - 1);
    }

}
