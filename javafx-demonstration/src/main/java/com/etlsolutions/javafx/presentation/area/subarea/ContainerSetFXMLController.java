package com.etlsolutions.javafx.presentation.area.subarea;

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
public class ContainerSetFXMLController extends AbstractComponentsFXMLController<ContainerSetDataModel> {

    @FXML
    private TextField volumeTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField heightTextField;    


    @Override
    public void initializeComponents() {

        
        volumeTextField.setText(model.getVolumeValueWrapper().getValue());
        volumeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        volumeTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getVolumeValueWrapper()));

//        numberTextField.setText(model.getNumberValueWrapper().getValue());
//        numberTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
//        numberTextField.textProperty().addListener(new NumberChangeAdapter(model));
 
        heightTextField.setText(model.getHeightValueWrapper().getValue());
        heightTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        heightTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getHeightValueWrapper()));        
    }
}
