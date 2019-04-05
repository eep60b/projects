package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDrapDroppedEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragExitedEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragEnteredEventHandler;
import com.etlsolutions.javafx.presentation.editor.graphic.area.CanvasDragOverEventHandler;
import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
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
    private AnchorPane editorPane;


    @FXML
    private Tab informationTab; 
    
    @FXML
    private VBox informationVbox;
    
    
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

        informationTextArea.setPrefSize(informationTab.getTabPane().getWidth(), informationTab.getTabPane().getHeight());
        informationTextArea.setBorder(Border.EMPTY);
        informationTextArea.setDisable(true);
        designPane.setPrefSize(designTab.getTabPane().getWidth(), designTab.getTabPane().getHeight());

        ValueWrapper<DataUnit> wrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();

        DataUnit data = wrapper.getValue();

        if (data != null) {

            informationTextArea.setText(data.displayMessage());
            for (ImageLink link : data.getImageLinks()) {
                imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
            }

            Button addImageButton = new Button("+");
            addImageButton.setOnAction(new AddImageToDataUnitEventHandler());
            imageTilePane.getChildren().add(addImageButton);
            data.addListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
            data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
        }
        
        designPane.setOnDragDropped(new CanvasDrapDroppedEventHandler());
        designPane.setOnDragEntered(new CanvasDragEnteredEventHandler());
        designPane.setOnDragExited(new CanvasDragExitedEventHandler());
        designPane.setOnDragOver(new CanvasDragOverEventHandler());

        designPane.heightProperty().addListener(new DesignPaneHeightChangeAdapter());
        designPane.widthProperty().addListener(new DesignPaneWidthChangeAdapter());

        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new EditorPropertyChangeAdapter(informationTextArea, imageTilePane));
    }
}
