package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class PlantThinningFXMLController extends AbstractComponentsFXMLController<PlantThinningTaskDataModel> {

    @FXML
    private HBox totalPlantNumberHBox;

    @FXML
    private HBox thinningRatioNumberHBox;

    @FXML
    private Label thinningPlantRemainingLabel;

    @Override
    public void initializeComponents() {

        Spinner<Integer> totalPlantsSpinner = new Spinner<>();
        totalPlantNumberHBox.getChildren().add(totalPlantsSpinner);
        SpinnerValueFactory.IntegerSpinnerValueFactory totalPlantfactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100000);
        totalPlantfactory.setValue(model.getTotalPlants().getValue());
        totalPlantsSpinner.setValueFactory(totalPlantfactory);
        totalPlantsSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getTotalPlants()));
        
        Spinner<Integer> thinningRatioSpinner = new Spinner<>();
        thinningRatioNumberHBox.getChildren().add(1, thinningRatioSpinner);
        SpinnerValueFactory.IntegerSpinnerValueFactory thinningRatioFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100000);
        thinningRatioFactory.setValue(model.getThinningRatio().getValue());
        thinningRatioSpinner.setValueFactory(thinningRatioFactory); 
        thinningRatioSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getThinningRatio()));
        
        thinningPlantRemainingLabel.setText(model.getRemainPlants());
        
        model.getTotalPlants().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantThinningPropertyChangeAdapter(model, thinningPlantRemainingLabel));
        model.getThinningRatio().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantThinningPropertyChangeAdapter(model, thinningPlantRemainingLabel));
    }
}
