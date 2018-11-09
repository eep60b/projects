package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.DigitalFilter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class FertiliserFXMLController extends DataUnitFXMLController<Fertiliser, AbstractFertiliserDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

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

    @FXML
    private ComboBox<FertiliserType> fertiliserTypeComboBox;

    @FXML
    private CheckBox aluminiumCheckBox;

    @FXML
    private TextField aluminiumTextField;

    @FXML
    private CheckBox boronCheckBox;

    @FXML
    private TextField boronTextField;

    @FXML
    private CheckBox calciumCheckBox;

    @FXML
    private TextField calciumTextField;

    @FXML
    private CheckBox chlorineCheckBox;

    @FXML
    private TextField chlorineTextField;

    @FXML
    private CheckBox cobaltCheckBox;

    @FXML
    private TextField cobaltTextField;

    @FXML
    private CheckBox copperCheckBox;

    @FXML
    private TextField copperTextField;

    @FXML
    private CheckBox ironCheckBox;

    @FXML
    private TextField ironTextField;

    @FXML
    private CheckBox magnesiumCheckBox;

    @FXML
    private TextField magnesiumTextField;

    @FXML
    private CheckBox manganeseCheckBox;

    @FXML
    private TextField manganeseTextField;

    @FXML
    private CheckBox molybdenumCheckBox;

    @FXML
    private TextField molybdenumTextField;

    @FXML
    private CheckBox nitrogenCheckBox;

    @FXML
    private TextField nitrogenTextField;

    @FXML
    private CheckBox nickelCheckBox;

    @FXML
    private TextField nickelTextField;

    @FXML
    private CheckBox phosphorusCheckBox;

    @FXML
    private TextField phosphorusTextField;

    @FXML
    private CheckBox potassiumCheckBox;

    @FXML
    private TextField potassiumTextField;

    @FXML
    private CheckBox seleniumCheckBox;

    @FXML
    private TextField seleniumTextField;

    @FXML
    private CheckBox sodiumCheckBox;

    @FXML
    private TextField sodiumTextField;

    @FXML
    private CheckBox sulphurCheckBox;

    @FXML
    private TextField sulphurTextField;

    @FXML
    private CheckBox vanadiumCheckBox;

    @FXML
    private TextField vanadiumTextField;

    @FXML
    private CheckBox zincCheckBox;

    @FXML
    private TextField zincTextField;

    @FXML
    private CheckBox phCheckBox;

    @FXML
    private TextField phTextField;

    @FXML
    private Tab additionalInformationTab;

    private final Map<FertiliserType, Node> map = new HashMap<>();

    @Override
    public void initializeComponents() {

        try {

            for (FertiliserType type : FertiliserType.values()) {
                PartDataModel m = model.getPartDataModel(type);
                FXMLLoader loader = new FXMLLoader(getClass().getResource(m.getFxmlPath()));
                Node node = (AnchorPane) loader.load();
                AbstractComponentsFXMLController<PartDataModel> controller = loader.getController();
                controller.setModel(m);
                controller.initializeComponents();
                map.put(type, node);
            }

            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

            fertiliserTypeComboBox.setItems(model.getTypes());
            fertiliserTypeComboBox.getSelectionModel().select(model.getType().getValue());
            fertiliserTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getType()));

            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));

            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));

            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));

            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));
            
            aluminiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getAluminium(), aluminiumTextField));

            aluminiumTextField.setVisible(Double.parseDouble(model.getAluminium().getValue()) != 0);
            aluminiumTextField.setText(model.getAluminium().getValue());
            aluminiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            aluminiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getAluminium()));

            additionalInformationTab.setContent(map.get(model.getPartDataModel().getType()));

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
