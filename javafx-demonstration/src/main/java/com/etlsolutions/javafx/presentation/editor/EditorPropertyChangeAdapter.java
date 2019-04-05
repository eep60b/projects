package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zc
 */
public class EditorPropertyChangeAdapter implements PropertyChangeListener {

    private final TextArea informationTextArea;
    private final TilePane imageTilePane;

    public EditorPropertyChangeAdapter(TextArea informationTextArea, TilePane imageTilePane) {
        this.informationTextArea = informationTextArea;
        this.imageTilePane = imageTilePane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        imageTilePane.getChildren().clear();
        
        ValueWrapper<DataUnit> wrapper = (ValueWrapper<DataUnit>) evt.getSource();
        DataUnit data = wrapper.getValue();

        if(data == null) {
            informationTextArea.setText("");
            
            return;
        }
        
        informationTextArea.setText(data.displayMessage());
        for (ImageLink link : data.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }

        Button addImageButton = new Button("+");
        addImageButton.setOnAction(new AddImageToDataUnitEventHandler());

        imageTilePane.getChildren().add(addImageButton);

        data.replaceListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
        data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
    }
}
