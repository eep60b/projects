package com.etlsolutions.javafx.presentation.log;

import com.etlsolutions.javafx.data.log.NotificationTimeUnit;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class NotificationFXMLController extends AbstractComponentStageFXMLController<NotificationDataModel> {

    @FXML
    private HBox notificationHbox;

    @FXML
    private ComboBox<NotificationTimeUnit> timeUnitComboBox;

    @FXML
    private HBox repeatTimesHbox;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    public NotificationFXMLController(NotificationDataModel model) {
        this.model = model;
    }

    @Override
    public void initializeComponents() {

        Spinner<Integer> lengthBeforeSpinner = new Spinner<>();
        IntegerSpinnerValueFactory lengthBeforeFactory = new IntegerSpinnerValueFactory(0, 100000);
        lengthBeforeFactory.setValue(model.getLengthBefore());
        lengthBeforeSpinner.setValueFactory(lengthBeforeFactory);
        notificationHbox.getChildren().add(1, lengthBeforeSpinner);

        timeUnitComboBox.setItems(model.getTimeUnits());
        timeUnitComboBox.getSelectionModel().select(model.getSelectedTimeUnit());

        Spinner<Integer> repeatTimesSpinner = new Spinner<>();
        IntegerSpinnerValueFactory repeatTimesFactory = new IntegerSpinnerValueFactory(0, 100000);
        repeatTimesFactory.setValue(model.getRepeatTimes());
        repeatTimesSpinner.setValueFactory(repeatTimesFactory);
        repeatTimesHbox.getChildren().add(repeatTimesSpinner);

        lengthBeforeSpinner.valueProperty().addListener(new LengthBeforeValueChangeAdapter(model));
        timeUnitComboBox.getSelectionModel().selectedItemProperty().addListener(new NotificationTimeUnitChangeAdapter(model));
        repeatTimesSpinner.valueProperty().addListener(new RepeatTimesChangeAdapter(model));

        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
    }
}
