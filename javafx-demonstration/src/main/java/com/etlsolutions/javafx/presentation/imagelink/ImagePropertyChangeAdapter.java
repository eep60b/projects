package com.etlsolutions.javafx.presentation.imagelink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Zhipeng
 */
public class ImagePropertyChangeAdapter implements PropertyChangeListener {

    private final Button addImageButton;
    private final Button okButton;
    private final HBox imageHBox;

    ImagePropertyChangeAdapter(Button addImageButton, Button okButton, HBox imageHBox) {
        this.addImageButton = addImageButton;
        this.okButton = okButton;
        this.imageHBox = imageHBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ImageDataModel model = (ImageDataModel) evt.getSource();
        addImageButton.setText(model.hasImage() ? "Change Image" : "Add Image");
        okButton.setDisable(!model.hasImage());
        
        ObservableList<Node> children = imageHBox.getChildren();        
        children.clear();
        children.add(new ImageView(model.getImageFileLink()));
    }
    
}
