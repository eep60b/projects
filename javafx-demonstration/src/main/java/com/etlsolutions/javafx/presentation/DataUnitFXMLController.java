package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import static com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel.*;
import com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
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
 * @param <E>
 * @param <T> - The data model type.
 */
public abstract class DataUnitFXMLController<E, T extends DataUnitFXMLDataModel<E>> extends AbstractComponentStageFXMLController<T> {

    protected void initCommonComponents(TextField titleTextField, TextArea informationTextArea, Pane imageTilePane, Button addImageButton,
            Button editImageButton, Button moveToBeginImageButton, Button moveToLeftImageButton, Button moveToRightImageButton, Button moveToEndImageButton, Button removeImageButton,
            Label errorMessageLabel, Button okButton, Button cancelButton) {

        titleTextField.setText(model.getTitle());
        informationTextArea.setText(model.getInformation());

        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);        
        editImageButton.setDisable(selectedImageLink == null);
        moveToBeginImageButton.setDisable(model.isNoOrFirstImage());
        moveToLeftImageButton.setDisable(model.isNoOrFirstImage());
        moveToEndImageButton.setDisable(model.isNoOrLastImage());
        moveToRightImageButton.setDisable(model.isNoOrLastImage());
  
        for (ImageLink link : model.getImageLinks()) {
            imageTilePane.getChildren().addAll(new ImageView(new Image(link.getLink())));
        }
        
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(model.isInvalid());

        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));

        addImageButton.setOnAction(new FXMLActionEventHandler<>(new AddImageDataModel(model)));
        removeImageButton.setOnAction(new RemoveEventHandler(model, SELECTED_IMAGE_LINK_REMOVE_EVENT_ID));
        moveToBeginImageButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new FXMLActionEventHandler<>(new EditImageInformationDataModel(model.getSelectedImageLink())));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        //Add change listeners to model.
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
        model.addPropertyChangeListener(SELECTED_IMAGE_LINK_PROPERTY, new ImageSelectionChangeAdapter(removeImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton));
    }
}
