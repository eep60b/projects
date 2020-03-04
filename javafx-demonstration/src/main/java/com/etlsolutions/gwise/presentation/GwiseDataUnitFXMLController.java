package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.presentation.dialog.adapter.ValidationPropertyChangeAdapter;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.presentation.dialog.adapter.GwiseImageSelectionChangeAdapter;
import com.etlsolutions.gwise.presentation.dialog.imagelink.GwiseMoveImageLinkToBeginEventHandler;
import com.etlsolutions.gwise.presentation.dialog.imagelink.GwiseMoveImageLinkToEndEventHandler;
import com.etlsolutions.gwise.presentation.dialog.imagelink.GwiseMoveImageLinkToLeftEventHandler;
import com.etlsolutions.gwise.presentation.dialog.imagelink.GwiseMoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import static com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel.*;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author zc
 * @param <D>
 * @param <T> - The data model type.
 */
public abstract class GwiseDataUnitFXMLController<D extends GwiseDataUnit, T extends GwiseDataUnitFXMLDataModel<D>> extends AbstractComponentStageFXMLController<T> {

    protected void initCommonComponents(TextField titleTextField, TextArea informationTextArea, Pane imageTilePane, Button addImageButton,
            Button editImageButton, Button moveToBeginImageButton, Button moveToLeftImageButton, Button moveToRightImageButton, Button moveToEndImageButton, Button removeImageButton,
            Label errorMessageLabel, Button okButton, Button cancelButton) {

        titleTextField.setText(model.getTitleValueWrapper().getValue());
        informationTextArea.setText(model.getInformationValueWrapper().getValue());

        ImageLink selectedImageLink = model.getSelectedImageLinkWrapper().getValue();
        removeImageButton.setDisable(selectedImageLink == null);        
        editImageButton.setDisable(selectedImageLink == null);
        moveToBeginImageButton.setDisable(model.getSelectedImgLinkIndex() < 1);
        moveToLeftImageButton.setDisable(model.getSelectedImgLinkIndex() < 1);
        moveToEndImageButton.setDisable(model.getSelectedImgLinkIndex() < 1 || model.getSelectedImgLinkIndex() == model.getImageLinks().size() - 1);
        moveToRightImageButton.setDisable(model.getSelectedImgLinkIndex() < 1 || model.getSelectedImgLinkIndex() == model.getImageLinks().size() - 1);
  
        for (ImageLink link : model.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }
        
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(model.isInvalid());

        titleTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getTitleValueWrapper()));
        informationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getInformationValueWrapper()));

        addImageButton.setOnAction(new GwiseAddImageToDataUnitFXMLDataModelEventHandler(model));
        removeImageButton.setOnAction(new RemoveEventHandler(model, SELECTED_IMAGE_LINK_REMOVE_EVENT_ID));
        moveToBeginImageButton.setOnAction(new GwiseMoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new GwiseMoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new GwiseMoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new GwiseMoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new GwiseEditImageToDataUnitEventHandler(model));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        //Add change listeners to model.
        model.getTitleValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));
        model.getSelectedImageLinkWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new GwiseImageSelectionChangeAdapter(model, removeImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton));
    }
}
