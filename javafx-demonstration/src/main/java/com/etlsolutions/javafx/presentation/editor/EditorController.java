package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class for the editor.
 *
 * @author zc
 */
public class EditorController extends AbstractFXMLController {

    public static final String EDITOR_VALUE_PROPERTY = EditorController.class.getName() + ".EDITOR_VALUE_PROPERTY";
    
    @FXML
    private AnchorPane editorPane;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private TilePane imageTilePane;
    
    @Override
    public void initializeComponents() {
        
        ValueWrapper<DataUnit> wrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();
        
        informationTextArea.setDisable(true);
        DataUnit data = wrapper.getValue();
        informationTextArea.setText(data.getInformation());
        for (ImageLink link : data.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }
        
        data.addListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
        data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new EditorPropertyChangeAdapter(informationTextArea, imageTilePane));
    }
}