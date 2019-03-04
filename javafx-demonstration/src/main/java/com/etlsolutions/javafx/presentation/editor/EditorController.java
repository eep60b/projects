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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

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
    private AnchorPane designPane;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private TilePane imageTilePane;
    
    @FXML
    private Button editInformationButton;

    @Override
    public void initializeComponents() {

        ValueWrapper<DataUnit> wrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();

        informationTextArea.setDisable(true);
        DataUnit data = wrapper.getValue();
        informationTextArea.setText(data.displayMessage());
        for (ImageLink link : data.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }
        
        Button addImageButton = new Button("+");
        addImageButton.setOnAction(new AddImageToDataUnitEventHandler());
        imageTilePane.getChildren().add(addImageButton);
        
        Canvas areaCanvas = new Canvas(1000, 1000);
        Canvas backgroundCanvas = new Canvas(1000, 1000);
        Canvas plantCanvas = new Canvas(1000, 1000);
        
        areaCanvas.setOnDragDropped(new CanvasDrapDroppedEventHandler());
        areaCanvas.setOnDragEntered(new CanvasDragEnteredEventHandler(areaCanvas));
        areaCanvas.setOnDragExited(new CanvasDragExitedEventHandler());
        areaCanvas.setOnDragOver(new CanvasDragOverEventHandler());
        
        AnchorPane.setTopAnchor(areaCanvas, 0d);
        AnchorPane.setLeftAnchor(areaCanvas, 0d);
        AnchorPane.setBottomAnchor(areaCanvas, 0d);
        AnchorPane.setRightAnchor(areaCanvas, 0d);
        final GraphicsContext gc = areaCanvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, areaCanvas.getWidth(), areaCanvas.getHeight());
        designPane.getChildren().add(areaCanvas);

        data.addListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
        data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
        wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new EditorPropertyChangeAdapter(informationTextArea, imageTilePane));
    }
}
