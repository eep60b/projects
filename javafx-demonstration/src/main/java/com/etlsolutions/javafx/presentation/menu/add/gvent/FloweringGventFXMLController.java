package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class FloweringGventFXMLController extends AbstractComponentsFXMLController<FloweringGventDetailDataModel> {

    @FXML
    private ComboBox flowerTypeComboBox;

    @FXML
    private ComboBox flowerColorComboBox;

    @FXML
    private CheckBox countableCheckBox;

    @FXML
    private HBox countHBox;

    @Override
    public void initializeComponents() {

        Spinner<Integer> countSpinner = new Spinner<>();
        IntegerSpinnerValueFactory lengthBeforeFactory = new IntegerSpinnerValueFactory(0, 100000);
        lengthBeforeFactory.setValue(model.getNumberPerPlantValueWrapper().getValue());
        countSpinner.setValueFactory(lengthBeforeFactory);
        countHBox.getChildren().add(countSpinner);

        flowerTypeComboBox.setItems(model.getFlowerTypes());
        flowerTypeComboBox.setEditable(true);
        flowerTypeComboBox.getSelectionModel().select(model.getFlowerTypeValueWrapper().getValue());
        flowerTypeComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getFlowerTypeValueWrapper()));

        flowerColorComboBox.setItems(model.getFlowerColors());
        flowerColorComboBox.setEditable(true);
        flowerColorComboBox.getSelectionModel().select(model.getColorValueWrapper().getValue());
        flowerColorComboBox.valueProperty().addListener(new ValueChangeAdapter<>(model.getColorValueWrapper()));

        boolean countable = model.getNumberPerPlantValueWrapper().getValue()>= 0;
        countableCheckBox.selectedProperty().setValue(countable);
        countableCheckBox.selectedProperty().addListener(new CountableChangeAdapter(model, countHBox));
        countHBox.setVisible(countable);

        countSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getNumberPerPlantValueWrapper()));
    }
}
