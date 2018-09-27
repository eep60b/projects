package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.presentation.menu.add.area.AddAreaEventHandler;
import com.etlsolutions.javafx.data.area.Area;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author zc
 */
public class AreaSelectionPage extends VBox {

    public AreaSelectionPage(AddLocationWizardDataModel model) {
        setSpacing(10);
        HBox areaHbox = new HBox();
        areaHbox.setSpacing(10);
        Label areaLabel = new Label("Select Area:");
        ComboBox<Area> areaComboBox = new ComboBox<>(model.getAreas());
        areaComboBox.getSelectionModel().select(model.getSelectedArea());
        areaComboBox.selectionModelProperty().addListener(new AreaSelectionChangeAdapter(model));        
        model.getAreas().addListener(new AreaListChangeAdapter(areaComboBox, model));
        
        Button addAreaButton = new Button("Add Area");
        addAreaButton.setOnAction(new AddAreaEventHandler());
        
        areaHbox.getChildren().addAll(areaLabel, areaComboBox, addAreaButton);
        super.getChildren().add(areaHbox);
    }
}