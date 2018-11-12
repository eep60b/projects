package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.log.task.HarvestingTaskDataModel;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class LiquidFertiliserFXMLController extends AbstractComponentsFXMLController<HarvestingTaskDataModel> {

    @FXML
    private ComboBox<String> qualityComboBox;

    @FXML
    private TextField harvestingQuantityTextField;
    
    @FXML
    private ComboBox<String> harvestingQuantityUomComboBox;


    @Override
    public void initializeComponents() {
                
        qualityComboBox.setItems(model.getHarvestingQualities());
        qualityComboBox.getSelectionModel().select(model.getQuality().getValue());
        qualityComboBox.setEditable(true);
        qualityComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getQuality()));

        harvestingQuantityTextField.setText(String.valueOf(model.getQuatantity().getValue()));
        harvestingQuantityTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        harvestingQuantityTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getQuatantity()));           
        
        harvestingQuantityUomComboBox.setItems(model.getHarvestingUoms());
        harvestingQuantityUomComboBox.setEditable(true);
        harvestingQuantityUomComboBox.getSelectionModel().select(model.getUom().getValue());
        harvestingQuantityUomComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getUom()));
    }
}
