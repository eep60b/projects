package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class FertilisationTaskFXMLController extends AbstractComponentsFXMLController<FertilisationTaskDetailDataModel> {

    @FXML
    private ComboBox<Fertiliser> fertiliserComboBox;

    @FXML
    private TextField fertiliserAmountTextField;
    
    @FXML
    private ComboBox<String> fertiliserUomComboBox;

    @FXML
    private Button addFertiliserButton;

    @FXML
    private Button editFertiliserButton;

    @FXML
    private Button removeFertiliserButton;

    @Override
    public void initializeComponents() {
                
        fertiliserComboBox.setItems(model.getFertilisers());
        fertiliserComboBox.getSelectionModel().select(model.getSelectedFertiliser().getValue());
        fertiliserComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedFertiliser()));

        fertiliserAmountTextField.setText(String.valueOf(model.getAmount().getValue()));
        fertiliserAmountTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        fertiliserAmountTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAmount()));           
        
        fertiliserUomComboBox.setItems(model.getUoms());
        fertiliserUomComboBox.setEditable(true);
        fertiliserUomComboBox.getSelectionModel().select(model.getSelectedUom().getValue());
        fertiliserUomComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getSelectedUom()));
    }
}
