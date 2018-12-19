package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.presentation.adapter.ImageSelectionChangeAdapter;
import com.etlsolutions.javafx.presentation.adapter.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import static com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel.*;
import com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
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
public abstract class DataUnitFXMLController<D extends DataUnit, T extends DataUnitFXMLDataModel<D>> extends AbstractComponentStageFXMLController<T> {

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
            imageTilePane.getChildren().addAll(new ImageView(new Image(link.getLink())));
        }
        
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(model.isInvalid());

        titleTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getTitleValueWrapper()));
        informationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getInformationValueWrapper()));

        addImageButton.setOnAction(new FXMLActionEventHandler<>(new AddImageDataModel(model)));
        removeImageButton.setOnAction(new RemoveEventHandler(model, SELECTED_IMAGE_LINK_REMOVE_EVENT_ID));
        moveToBeginImageButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new FXMLActionEventHandler<>(new EditImageInformationDataModel(model.getSelectedImageLinkWrapper().getValue())));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        //Add change listeners to model.
        model.getTitleValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));
        model.getSelectedImageLinkWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ImageSelectionChangeAdapter(model, removeImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton));
    }
}
