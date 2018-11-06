package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class PruningTaskFXMLController  extends AbstractComponentsFXMLController<PruningTaskDataModel> {

    @FXML
    private TextField orverallRemovedTextField;
    
    @FXML
    private TextField eachBranchRemovedTextField;    

    @Override
    public void initializeComponents() {

        orverallRemovedTextField.setText(String.valueOf(model.getOverallRemoved().getValue()));
        orverallRemovedTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        orverallRemovedTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getOverallRemoved()));           
        
        eachBranchRemovedTextField.setText(String.valueOf(model.getEachBranchRemoved().getValue()));
        eachBranchRemovedTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        eachBranchRemovedTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getEachBranchRemoved()));   
    }
}
