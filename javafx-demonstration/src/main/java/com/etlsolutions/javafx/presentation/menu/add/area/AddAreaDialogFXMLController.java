package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.data.area.AreaShapeType;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import static com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddAreaDialogFXMLController extends DataUnitFXMLController<AddAreaDialogDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<AreaType> typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<AreaShapeType> shapeTypeComboBox;

    @FXML
    private HBox areaShapeContentHbox;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private TextField latitudeTextField;

    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToBeginImageButton;

    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;

    @FXML
    private Button moveToEndImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Tab contentsTab;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    /**
     * Initialises the components in this dialog.
     *
     */
    @Override
    public void initializeComponents() {

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        typeComboBox.setItems(model.getAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedAreaType());
        shapeTypeComboBox.setItems(model.getAreaShapeTypes());
        shapeTypeComboBox.getSelectionModel().select(model.getSelectedAreaShapeType());

        Label lengthLabel = new Label("Length");
        TextField lengthTextField = new TextField();
        lengthTextField.setMinWidth(Region.USE_COMPUTED_SIZE);
        lengthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        
        Label widthLabel = new Label("Width");
        widthLabel.setMinWidth(Region.USE_COMPUTED_SIZE);
        TextField widthTextField = new TextField();
        widthTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        Label sideLabel = new Label("Side");
        TextField sideTextField = new TextField();
        sideLabel.setMinWidth(Region.USE_COMPUTED_SIZE);
        sideTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        Label diameterLabel = new Label("Diameter");
        diameterLabel.setMinWidth(Region.USE_COMPUTED_SIZE);
        TextField diameterTextField = new TextField();
        diameterTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        Label aLebel = new Label("A");
        TextField aTextField = new TextField(String.valueOf(model.getA()));
        aTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        Label bLebel = new Label("B");
        TextField bTextField = new TextField(String.valueOf(model.getB()));
        bTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        Label cLebel = new Label("C");
        TextField cTextField = new TextField(String.valueOf(model.getC()));
        cTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        Label areaLabel = new Label("Area");
        TextField areaTextField = new TextField(String.valueOf(model.getAreaValue()));

        ObservableList<Node> children = areaShapeContentHbox.getChildren();
        children.clear();
        switch (model.getSelectedAreaShapeType()) {
            case RECTANGLE:
                children.addAll(areaLabel, areaTextField, lengthLabel, lengthTextField, widthLabel, widthTextField);
                areaTextField.setDisable(true);
                break;
            case SQURE:
                children.addAll(areaLabel, areaTextField, sideLabel, sideTextField);
                areaTextField.setDisable(true);
                break;
            case CIRCLE:
                children.addAll(areaLabel, areaTextField, diameterLabel, diameterTextField);
                areaTextField.setDisable(true);
                break;
            case TRIANGLE:
                children.addAll(areaLabel, areaTextField, aLebel, aTextField, bLebel, bTextField, cLebel, cTextField);
                areaTextField.setDisable(true);
                break;
            case IRREGULAR:
                children.addAll(areaLabel, areaTextField);
                areaTextField.setDisable(false);
        }

        longitudeTextField.setText(String.valueOf(model.getLongitude()));
        longitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
        latitudeTextField.setText(String.valueOf(model.getLatitude()));
        latitudeTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));

        VBox customAreaContent = new CustomAreaContent(model);
        switch (model.getSelectedAreaType()) {
            case CUSTOM:
                contentsTab.setContent(customAreaContent);
                break;
        }

        typeComboBox.selectionModelProperty().addListener(new AreaTypeChangeAdapter(model));
        shapeTypeComboBox.selectionModelProperty().addListener(new AreaShapeTypeChangeAdapter(model));
        lengthTextField.textProperty().addListener(new LengthChangeAdapter(model));
        widthTextField.textProperty().addListener(new WidthChangeAdapter(model));
        sideTextField.textProperty().addListener(new SideChangeAdapter(model));
        diameterTextField.textProperty().addListener(new DiameterChangeAdapter(model));
        aTextField.textProperty().addListener(new TriangleaChangeAdapter(model));
        bTextField.textProperty().addListener(new TrianglebChangeAdapter(model));
        cTextField.textProperty().addListener(new TrianglecChangeAdapter(model));
        areaTextField.textProperty().addListener(new AreaChangeAdapter(model));
        longitudeTextField.textProperty().addListener(new LongitudeChangeAdapter(model));
        latitudeTextField.textProperty().addListener(new LatitudeChangeAdapter(model));

        model.addPropertyChangeListener(AREA_SHAPE_TYPE_PROPERTY,
                new AreaShapeTypePropertyChangeAdapter(areaShapeContentHbox, lengthLabel, lengthTextField, widthLabel, widthTextField,
                        sideLabel, sideTextField, diameterLabel, diameterTextField, aLebel, aTextField, bLebel, bTextField, cLebel, cTextField, areaLabel, areaTextField));

        model.addPropertyChangeListener(AREA_SHAPE_VALUE_PROPERTY, new AreaShapeValuePropertyChangeAdapter(areaTextField));
    }
}
