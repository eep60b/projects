package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author zc
 */
public class SelectedImageLinkAdapter implements PropertyChangeListener {

    private final Button removeImageButton;
    private final Button moveToBeginButton;
    private final Button moveToLeftButton;
    private final Button moveToEndButton;
    private final Button moveToRightButton;
    private final Button editImageInformationButton;
    private final HBox imagesHbox;


    public SelectedImageLinkAdapter(Button removeImageButton, Button moveToBeginButton, Button moveToLeftButton, Button moveToEndButton, Button moveToRightButton, Button editImageInformationButton, HBox imagesHbox) {
        this.removeImageButton = removeImageButton;
        this.moveToBeginButton = moveToBeginButton;
        this.moveToLeftButton = moveToLeftButton;
        this.moveToEndButton = moveToEndButton;
        this.moveToRightButton = moveToRightButton;
        this.editImageInformationButton = editImageInformationButton;
        this.imagesHbox = imagesHbox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DataUnitFXMLDataModel model = (DataUnitFXMLDataModel) evt.getSource();
        ImageLink selectedImageLink = (ImageLink)model.getSelectedImageLinkWrapper().getValue();
        removeImageButton.setDisable(selectedImageLink == null);
        editImageInformationButton.setDisable(selectedImageLink == null);
        List<ImageLink> imageLinks = model.getImageLinks();
        moveToBeginButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToLeftButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToEndButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        moveToRightButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        
        ObservableList<Node> children = imagesHbox.getChildren();
        
        for(Node child : children) {
            ImageView i = (ImageView) child;
            ImageLink link = ((LocallyLinkedImage)i.getImage()).getLink();
            if(link.equals(model.getSelectedImageLinkWrapper().getValue())) {
                i.setStyle("-fx-background-color: BLACK");
            } else {
                i.setStyle("-fx-background-color: WHITE");
            }
        }
    }

}
