package com.etlsolutions.javafx.presentation.menu.add.locationwizard;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author zc
 */
public class SubAreaSelectionPage extends VBox {

    public SubAreaSelectionPage(AddLocationWizardDataModel model) {
        setSpacing(10);
        HBox areaHBox = new HBox();
        Label areaTypeTitleLabel = new Label("Area Type:");
        Label areaTypeLabel = new Label(model.getSelectedArea().getType().getTitle());
        areaTypeLabel.setTextFill(Color.GREY);
        Label areaTitleTitleLabel = new Label("Area Title:");
        Label areaTitleLabel = new Label(model.getSelectedArea().getTitle());
        areaTitleLabel.setTextFill(Color.GREY);
        areaHBox.getChildren().addAll(areaTypeTitleLabel, areaTypeLabel, areaTitleTitleLabel, areaTitleLabel);
        
        HBox subAreaTypeHbox = new HBox();
        subAreaTypeHbox.setSpacing(10);
        Label subAreaTypeLabel = new Label("Type:");
        ComboBox<SubAreaType> subAreaTypeComboBox = new ComboBox<>(model.getSubAreaTypes());
        subAreaTypeComboBox.getSelectionModel().select(model.getSelectedSubAreaType());
        subAreaTypeComboBox.selectionModelProperty().addListener(new SubAreaTypeSelectionChangeAdapter(model));
        subAreaTypeHbox.getChildren().addAll(subAreaTypeLabel, subAreaTypeComboBox);

        HBox subAreaHbox = new HBox();
        subAreaHbox.setSpacing(10);
        Label areaLabel = new Label("Select One:");
        ComboBox<SubArea> areaComboBox = new ComboBox<>(model.getSubAreas());
        areaComboBox.getSelectionModel().select(model.getSelectedSubArea());
        areaComboBox.selectionModelProperty().addListener(new SubAreaSelectionChangeAdapter(model));
       // model.getSubAreas().addListener(new SubAreaListChangeAdapter(areaComboBox, model));

        Button addAreaButton = new Button("Add New");
        addAreaButton.setOnAction(new FXMLActionEventHandler<>(model));

        subAreaHbox.getChildren().addAll(areaLabel, areaComboBox, addAreaButton);
        super.getChildren().addAll(subAreaTypeHbox, subAreaHbox);
    }

}
