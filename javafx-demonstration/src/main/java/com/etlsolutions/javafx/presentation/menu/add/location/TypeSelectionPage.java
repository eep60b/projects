package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.presentation.menu.add.area.AddAreaEventHandler;
import com.etlsolutions.javafx.data.area.Area;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author zc
 */
public class TypeSelectionPage extends VBox {

    private final TypeSelectionDataModel model;

    public TypeSelectionPage(TypeSelectionDataModel model) {
        this.model = model;
        setSpacing(10);
        HBox areaHbox = new HBox();
        areaHbox.setSpacing(5);
        Label areaLabel = new Label("Select an Area:");
        ComboBox<Area> areaComboBox = new ComboBox<>(model.getAreas());
        areaComboBox.getSelectionModel().select(model.getSelectedArea());
        areaComboBox.selectionModelProperty().addListener(new AreaSelectionChangeAdapter(model));        
        model.getAreas().addListener(new AreaListChangeAdapter(areaComboBox, model));
        
        Button button = new Button("Add an Area");
        button.setOnAction(new AddAreaEventHandler());
    }
}
