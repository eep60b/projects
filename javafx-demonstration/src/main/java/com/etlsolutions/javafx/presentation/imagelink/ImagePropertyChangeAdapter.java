package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
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
        errorMessageLabel.setVisible(!invalid);
        errorMessageLabel.setText(invalid ? "Invalid image path." : "");

        if (!invalid) {
            ObservableList<Node> children = imageHbox.getChildren();
            children.clear();
            children.add(new ImageView(link));
        }
    }

}
