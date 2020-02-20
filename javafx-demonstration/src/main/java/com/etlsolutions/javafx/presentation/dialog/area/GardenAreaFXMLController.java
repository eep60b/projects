package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class GardenAreaFXMLController extends AbstractComponentStageFXMLController<AbstractAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<MeasurementType> shapeComboBox;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    /**
     * Initialises the components in this dialog.
     *
     * @throws java.lang.Exception
     */
    @Override
    public void initializeComponents() throws Exception {
        
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(model.isInvalid());

        titleTextField.setText(model.getTitleValueWrapper().getValue());
        informationTextArea.setText(model.getInformationValueWrapper().getValue());

        titleTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getTitleValueWrapper()));
        informationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getInformationValueWrapper()));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        model.getTitleValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));

    }
}
