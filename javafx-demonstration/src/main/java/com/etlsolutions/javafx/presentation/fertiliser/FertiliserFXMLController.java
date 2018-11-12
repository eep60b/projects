package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.presentation.PartDataModel;
import com.etlsolutions.javafx.data.ValueWrapper;
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

            boronCheckBox.selectedProperty().setValue(Double.parseDouble(model.getBoron().getValue()) != 0);
            boronCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getBoron(), boronTextField));

            boronTextField.setVisible(Double.parseDouble(model.getBoron().getValue()) != 0);
            boronTextField.setText(model.getBoron().getValue());
            boronTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            boronTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getBoron()));

            calciumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getCalcium().getValue()) != 0);
            calciumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getCalcium(), calciumTextField));

            calciumTextField.setVisible(Double.parseDouble(model.getCalcium().getValue()) != 0);
            calciumTextField.setText(model.getCalcium().getValue());
            calciumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            calciumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getCalcium()));

            chlorineCheckBox.selectedProperty().setValue(Double.parseDouble(model.getChlorine().getValue()) != 0);
            chlorineCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getChlorine(), chlorineTextField));

            chlorineTextField.setVisible(Double.parseDouble(model.getChlorine().getValue()) != 0);
            chlorineTextField.setText(model.getChlorine().getValue());
            chlorineTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            chlorineTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getChlorine()));
            
            cobaltCheckBox.selectedProperty().setValue(Double.parseDouble(model.getCobalt().getValue()) != 0);
            cobaltCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getCobalt(), cobaltTextField));

            cobaltTextField.setVisible(Double.parseDouble(model.getCobalt().getValue()) != 0);
            cobaltTextField.setText(model.getCobalt().getValue());
            cobaltTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            cobaltTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getCobalt()));
            
            copperCheckBox.selectedProperty().setValue(Double.parseDouble(model.getCopper().getValue()) != 0);
            copperCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getCopper(), copperTextField));

            copperTextField.setVisible(Double.parseDouble(model.getCopper().getValue()) != 0);
            copperTextField.setText(model.getCopper().getValue());
            copperTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            copperTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getCopper()));
            
            ironCheckBox.selectedProperty().setValue(Double.parseDouble(model.getIron().getValue()) != 0);
            ironCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getIron(), ironTextField));

            ironTextField.setVisible(Double.parseDouble(model.getIron().getValue()) != 0);
            ironTextField.setText(model.getIron().getValue());
            ironTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            ironTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getIron()));
            
            magnesiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getMagnesium().getValue()) != 0);
            magnesiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getMagnesium(), magnesiumTextField));

            magnesiumTextField.setVisible(Double.parseDouble(model.getMagnesium().getValue()) != 0);
            magnesiumTextField.setText(model.getMagnesium().getValue());
            magnesiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            magnesiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getMagnesium()));
            
            manganeseCheckBox.selectedProperty().setValue(Double.parseDouble(model.getManganese().getValue()) != 0);
            manganeseCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getManganese(), manganeseTextField));

            manganeseTextField.setVisible(Double.parseDouble(model.getManganese().getValue()) != 0);
            manganeseTextField.setText(model.getManganese().getValue());
            manganeseTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            manganeseTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getManganese()));
            
            molybdenumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getMolybdenum().getValue()) != 0);
            molybdenumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getMolybdenum(), molybdenumTextField));

            molybdenumTextField.setVisible(Double.parseDouble(model.getMolybdenum().getValue()) != 0);
            molybdenumTextField.setText(model.getMolybdenum().getValue());
            molybdenumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            molybdenumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getMolybdenum()));
            
            nitrogenCheckBox.selectedProperty().setValue(Double.parseDouble(model.getNitrogen().getValue()) != 0);
            nitrogenCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getNitrogen(), nitrogenTextField));

            nitrogenTextField.setVisible(Double.parseDouble(model.getNitrogen().getValue()) != 0);
            nitrogenTextField.setText(model.getNitrogen().getValue());
            nitrogenTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            nitrogenTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getNitrogen()));
            
            nickelCheckBox.selectedProperty().setValue(Double.parseDouble(model.getNickel().getValue()) != 0);
            nickelCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getNickel(), nickelTextField));

            nickelTextField.setVisible(Double.parseDouble(model.getNickel().getValue()) != 0);
            nickelTextField.setText(model.getNickel().getValue());
            nickelTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            nickelTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getNickel()));
            
            phosphorusCheckBox.selectedProperty().setValue(Double.parseDouble(model.getPhosphorus().getValue()) != 0);
            phosphorusCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getPhosphorus(), phosphorusTextField));

            phosphorusTextField.setVisible(Double.parseDouble(model.getPhosphorus().getValue()) != 0);
            phosphorusTextField.setText(model.getPhosphorus().getValue());
            phosphorusTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            phosphorusTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getPhosphorus()));
            
            potassiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getPotassium().getValue()) != 0);
            potassiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getPotassium(), potassiumTextField));

            potassiumTextField.setVisible(Double.parseDouble(model.getPotassium().getValue()) != 0);
            potassiumTextField.setText(model.getPotassium().getValue());
            potassiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            potassiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getPotassium()));
            
            seleniumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getSelenium().getValue()) != 0);
            seleniumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getSelenium(), seleniumTextField));

            seleniumTextField.setVisible(Double.parseDouble(model.getSelenium().getValue()) != 0);
            seleniumTextField.setText(model.getSelenium().getValue());
            seleniumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            seleniumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSelenium()));
            
            sodiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getSodium().getValue()) != 0);
            sodiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getSodium(), sodiumTextField));

            sodiumTextField.setVisible(Double.parseDouble(model.getSodium().getValue()) != 0);
            sodiumTextField.setText(model.getSodium().getValue());
            sodiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            sodiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSodium()));
            
            sulphurCheckBox.selectedProperty().setValue(Double.parseDouble(model.getSulphur().getValue()) != 0);
            sulphurCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getSulphur(), sulphurTextField));

            sulphurTextField.setVisible(Double.parseDouble(model.getSulphur().getValue()) != 0);
            sulphurTextField.setText(model.getSulphur().getValue());
            sulphurTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            sulphurTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getSulphur()));
            
            vanadiumCheckBox.selectedProperty().setValue(Double.parseDouble(model.getVanadium().getValue()) != 0);
            vanadiumCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getVanadium(), vanadiumTextField));

            vanadiumTextField.setVisible(Double.parseDouble(model.getVanadium().getValue()) != 0);
            vanadiumTextField.setText(model.getVanadium().getValue());
            vanadiumTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            vanadiumTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getVanadium()));
            
            zincCheckBox.selectedProperty().setValue(Double.parseDouble(model.getZinc().getValue()) != 0);
            zincCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getZinc(), zincTextField));

            zincTextField.setVisible(Double.parseDouble(model.getZinc().getValue()) != 0);
            zincTextField.setText(model.getZinc().getValue());
            zincTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            zincTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getZinc()));
            
            phCheckBox.selectedProperty().setValue(Double.parseDouble(model.getPh().getValue()) != 0);
            phCheckBox.selectedProperty().addListener(new BooleanValueNodeChangeAdapter(model.getPh(), phTextField));

            phTextField.setVisible(Double.parseDouble(model.getPh().getValue()) != 0);
            phTextField.setText(model.getPh().getValue());
            phTextField.setTextFormatter(new TextFormatter<>(new DigitalFilter()));
            phTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getPh()));

            additionalInformationTab.setContent(map.get(model.getPartDataModel().getItemPartValueWrapper().getType()));
            
            model.getType().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new TypePropertyChangeAdapter(map, additionalInformationTab));

        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

}
