package com.etlsolutions.javafx.presentation.imagelink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Zhipeng
 */
public class ImagePropertyChangeAdapter implements PropertyChangeListener {

    private final HBox imageHbox;
    private final Label errorMessageLabel;
    private final Button okButton;

    public ImagePropertyChangeAdapter(HBox imageHbox,  Label errorMessageLabel, Button okButton) {
        this.okButton = okButton;
        this.errorMessageLabel = errorMessageLabel;
        this.imageHbox = imageHbox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddImageDataModel model = (AddImageDataModel) evt.getSource();
        boolean valid = model.isValid();
        okButton.setDisable(valid);
        errorMessageLabel.setVisible(!valid);
        errorMessageLabel.setText(model.getErrorMessage());
        
        if(valid) {
        ObservableList<Node> children = imageHbox.getChildren();        
        children.clear();
        children.add(new ImageView(model.getImageFileLink()));
        }
    }
    
}
