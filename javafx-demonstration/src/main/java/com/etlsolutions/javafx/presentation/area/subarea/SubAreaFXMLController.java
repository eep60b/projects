package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import static com.etlsolutions.javafx.presentation.area.AbstractAreaDataModel.AREA_SHAPE_TYPE_PROPERTY;
import static com.etlsolutions.javafx.presentation.area.AbstractAreaDataModel.AREA_SHAPE_VALUE_PROPERTY;
import com.etlsolutions.javafx.presentation.area.AreaValueChangeAdapter;
import com.etlsolutions.javafx.presentation.area.AreaShapeChangeAdapter;
import com.etlsolutions.javafx.presentation.area.AreaShapePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.area.AreaValuePropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.area.AreaTypeChangeAdapter;
import com.etlsolutions.javafx.presentation.area.CustomAreaContent;
import com.etlsolutions.javafx.presentation.area.DiameterChangeAdapter;
import com.etlsolutions.javafx.presentation.area.LatitudeChangeAdapter;
import com.etlsolutions.javafx.presentation.area.LengthChangeAdapter;
import com.etlsolutions.javafx.presentation.area.LongitudeChangeAdapter;
import com.etlsolutions.javafx.presentation.area.SideChangeAdapter;
import com.etlsolutions.javafx.presentation.area.TriangleaChangeAdapter;
import com.etlsolutions.javafx.presentation.area.TrianglebChangeAdapter;
import com.etlsolutions.javafx.presentation.area.TrianglecChangeAdapter;
import com.etlsolutions.javafx.presentation.area.WidthChangeAdapter;
import static com.etlsolutions.javafx.presentation.area.subarea.AbstractSubAreaDataModel.*;
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
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class SubAreaFXMLController extends DataUnitFXMLController<AbstractSubAreaDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<SubAreaType> typeComboBox;

    @FXML
    private ComboBox<SubAreaShape> shapeComboBox;

    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Tab measurementTab;    
   
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

        typeComboBox.setItems(model.getSubAreaTypes());
        typeComboBox.getSelectionModel().select(model.getSelectedSubAreaType());
        typeComboBox.setDisable(model.getSubAreaTypes().size() <= 1);
        shapeComboBox.setItems(model.getAreaShapeTypes());
        shapeComboBox.getSelectionModel().select(model.getSelectedSubAreaShape());

        typeComboBox.selectionModelProperty().addListener(new SubAreaTypeChangeAdapter(model));
        shapeComboBox.selectionModelProperty().addListener(new SubAreaShapeChangeAdapter(model));

        model.addPropertyChangeListener(SUB_AREA_TYPE_PROPERTY, new SubAreaTypePropertyChangeAdapter(shapeComboBox));
        model.addPropertyChangeListener(SUB_AREA_SHAPE_PROPERTY, new SubAreShapePropertyChangeAdapter(measurementTab));
    }
}
