package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.AbstractFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class for the editor.
 *
 * @author zc
 */
public class EditorController extends AbstractFXMLController {

    @FXML
    AnchorPane editorPane;
    
    @FXML
    TextArea informationTextArea;
    
    @Override
    public void initializeComponents() {
        
    }
}