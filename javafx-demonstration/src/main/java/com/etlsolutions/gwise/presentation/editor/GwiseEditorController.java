package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.presentation.editor.designtab.GwiseDesignPaneDataModel;
import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.editor.EditorController;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for the editor.
 *
 * @author zc
 */
public class GwiseEditorController extends AbstractFXMLController {

    public static final String EDITOR_VALUE_PROPERTY = EditorController.class.getName() + ".EDITOR_VALUE_PROPERTY";

    @FXML
    private TabPane editorTabPane;

    @FXML
    private Tab informationTab;

    @FXML
    private VBox informationVbox;

    @FXML
    private ScrollPane informationScrollPane;

    @FXML
    private Tab designTab;

    @FXML
    private StackPane designPane;
   

    @FXML
    private TextArea informationTextArea;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Button editInformationButton;

    @Override
    public void initializeComponents() {
        
        GwiseDesignPaneDataModel designPaneDataModel = new GwiseDesignPaneDataModel();

        TabPane firstTabPane = informationTab.getTabPane();

        informationVbox.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        informationScrollPane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        informationTextArea.setPrefWidth(firstTabPane.getWidth());
        informationTextArea.setBorder(Border.EMPTY);
        informationTextArea.setDisable(true);

        imageTilePane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());

        designPane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        LineChart backgroudLineChart = new LineChart(new NumberAxis(0, 100, 1), new NumberAxis(0, 100, 1));
        backgroudLineChart.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());

        ValueWrapper<GwiseDataUnit> wrapper = ProjectManager.getInstance().getSelectedGwiseDataUnitValueWrapper();
        GwiseEditorPropertyChangeAdapter editorPropertyChangeAdapter = new GwiseEditorPropertyChangeAdapter(wrapper.getValue(), designPaneDataModel, editorTabPane, informationTextArea, imageTilePane, designTab, designPane);
        editorPropertyChangeAdapter.process(wrapper);

        firstTabPane.heightProperty().addListener(new DesignPaneHeightChangeAdapter(informationVbox, informationScrollPane, informationTextArea,
                imageTilePane, designPane, backgroudLineChart));
        firstTabPane.widthProperty().addListener(new DesignPaneWidthChangeAdapter(informationVbox, informationScrollPane, informationTextArea,
                imageTilePane, designPane, backgroudLineChart));

        designPane.getChildren().add(backgroudLineChart);

        wrapper.addNonDuplicatedDataUnitPropertyChangeAdapter(ValueWrapper.VALUE_CHANGE, editorPropertyChangeAdapter);
    }
}