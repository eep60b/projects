package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneCancelAreaEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.AddItemToDesignPaneEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDataModel;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDrapDroppedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDragExitedEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDragEnteredEventHandler;
import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDragOverEventHandler;
import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
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
public class EditorController extends AbstractFXMLController {

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
    private Button addAreaButton;
    
    @FXML
    private Button cancelAreaButton;    

    @FXML
    private TextArea informationTextArea;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Button editInformationButton;

    @Override
    public void initializeComponents() {

        addAreaButton.setVisible(false);
        addAreaButton.setDisable(true);
        cancelAreaButton.setVisible(false);
        cancelAreaButton.setDisable(true);
        
        DesignPaneDataModel designPaneDataModel = new DesignPaneDataModel();

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

        ValueWrapper<DataUnit> wrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();
        EditorPropertyChangeAdapter editorPropertyChangeAdapter = new EditorPropertyChangeAdapter(designPaneDataModel, editorTabPane, informationTextArea, imageTilePane, designTab, designPane);
        editorPropertyChangeAdapter.process(wrapper);

        firstTabPane.heightProperty().addListener(new DesignPaneHeightChangeAdapter(informationVbox, informationScrollPane, informationTextArea,
                imageTilePane, designPane, backgroudLineChart));
        firstTabPane.widthProperty().addListener(new DesignPaneWidthChangeAdapter(informationVbox, informationScrollPane, informationTextArea,
                imageTilePane, designPane, backgroudLineChart));

        designPane.getChildren().add(backgroudLineChart);

        backgroudLineChart.setOnDragDropped(new DesignPaneDrapDroppedEventHandler(designPaneDataModel));
        backgroudLineChart.setOnDragEntered(new DesignPaneDragEnteredEventHandler(designPane, addAreaButton, cancelAreaButton, designPaneDataModel));
        backgroudLineChart.setOnDragExited(new DesignPaneDragExitedEventHandler(designPane));
        backgroudLineChart.setOnDragOver(new DesignPaneDragOverEventHandler());

        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, editorPropertyChangeAdapter);
        addAreaButton.setOnAction(new AddItemToDesignPaneEventHandler(designPane));
        cancelAreaButton.setOnAction(new DesignPaneCancelAreaEventHandler(designPane));
        designPaneDataModel.addPropertyChangeListener(DesignPaneDataModel.AREA_DROPPED_PROPERTY, new DesignPaneAreaDroppedPropertyChangeAdapter(designPane));
    }
}