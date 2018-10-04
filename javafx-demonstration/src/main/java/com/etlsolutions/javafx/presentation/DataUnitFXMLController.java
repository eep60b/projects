package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.ImageLink;
import static com.etlsolutions.javafx.presentation.DataUnitDataModel.*;
import com.etlsolutions.javafx.presentation.imagelink.AddImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.RemoveImageLinkEventHandler;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 * @param <T> - The data model type.
 */
public abstract class DataUnitFXMLController<T extends DataUnitDataModel> extends AbstractFXMLController<T> {

    protected void initCommonComponents(TextField titleTextField, TextArea informationTextArea, TilePane imageTilePane, Button addImageButton,
            Button editImageButton, Button moveToBeginImageButton, Button moveToLeftImageButton, Button moveToRightImageButton, Button moveToEndImageButton, Button removeImageButton,
            Label errorMessageLabel, Button okButton, Button cancelButton) {

        titleTextField.setText(model.getTitle());
        informationTextArea.setText(model.getInformation());

        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);        
        editImageButton.setDisable(selectedImageLink == null);
        moveToBeginImageButton.setDisable(model.isFirstImage());
        moveToLeftImageButton.setDisable(model.isFirstImage());
        moveToEndImageButton.setDisable(model.isLastImage());
        moveToRightImageButton.setDisable(model.isLastImage());
  
        for (ImageLink link : model.getImageLinks()) {
            imageTilePane.getChildren().addAll(new ImageView(new Image(link.getLink())));
        }
        
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());

        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));

        addImageButton.setOnAction(new AddImageLinkEventHandler(model));
        removeImageButton.setOnAction(new RemoveImageLinkEventHandler(model));
        moveToBeginImageButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new EditImageInformationEventHandler(model.getSelectedImageLink()));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        //Add change listeners to model.
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
        model.addPropertyChangeListener(SELECTED_IMAGE_LINK_PROPERTY, new ImageSelectionChangeAdapter(removeImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton));
    }
}
