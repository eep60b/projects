package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDrapDroppedEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragExitedEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragEnteredEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragOverEventHandler;
import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
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

    /**
     * The Canvas will be used to draw ruler and grid.
     */
    @FXML
    private Canvas backgroundCanvas;

    /**
     * The canvas will be used tor draw irregular shape of subarea.
     */
    @FXML
    private Canvas irregularAreaCanvas;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Button editInformationButton;



    @Override
    public void initializeComponents() {

        EditorDataModel model = new EditorDataModel();
        
        TabPane firstTabPane = informationTab.getTabPane();
        
        informationVbox.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        informationScrollPane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        informationTextArea.setPrefWidth(firstTabPane.getWidth());
        informationTextArea.setBorder(Border.EMPTY);
        informationTextArea.setDisable(true);
        
        imageTilePane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        
        designPane.setPrefSize(firstTabPane.getWidth(), firstTabPane.getHeight());
        
        ValueWrapper<DataUnit> wrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();
        EditorPropertyChangeAdapter editorPropertyChangeAdapter = new EditorPropertyChangeAdapter(model, editorTabPane, informationTextArea, imageTilePane, designTab, designPane);        
        editorPropertyChangeAdapter.process(wrapper);

        firstTabPane.heightProperty().addListener(new DesignPaneHeightChangeAdapter(informationVbox, informationScrollPane, informationTextArea, imageTilePane, designPane));
        firstTabPane.widthProperty().addListener(new DesignPaneWidthChangeAdapter(informationVbox, informationScrollPane, informationTextArea, imageTilePane, designPane));
        
        designPane.setOnDragDropped(new CanvasDrapDroppedEventHandler());
        designPane.setOnDragEntered(new CanvasDragEnteredEventHandler());
        designPane.setOnDragExited(new CanvasDragExitedEventHandler());
        designPane.setOnDragOver(new CanvasDragOverEventHandler());
        
        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, editorPropertyChangeAdapter);
    }

}
