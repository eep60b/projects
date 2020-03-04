package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    public ImagePropertyChangeAdapter(HBox imageHbox, Label errorMessageLabel, Button okButton) {
        this.okButton = okButton;
        this.errorMessageLabel = errorMessageLabel;
        this.imageHbox = imageHbox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<String>) evt.getSource());
    }

    public void process(ValueWrapper<String> wrapper) {
        String link = wrapper.getValue(); 
        boolean invalid = link == null || !new File(link).isFile();
        okButton.setDisable(invalid);
        errorMessageLabel.setVisible(invalid);
        errorMessageLabel.setText(invalid ? "Invalid image path." : "");

        if (!invalid) {
            ObservableList<Node> children = imageHbox.getChildren();
            children.clear();
            try {
                children.add(new ImageView(new Image(new FileInputStream(new File(link)))));
            } catch (FileNotFoundException ex) {
                throw new CustomLevelErrorRuntimeExceiption("The image file is missing.", ex);
            }
        }
    }

}
