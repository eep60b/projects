package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.gwise.presentation.palette.DragDoneEventHandler;
import com.etlsolutions.gwise.presentation.palette.DragDetectedEventHandler;
import com.etlsolutions.gwise.presentation.palette.MouseReleaseEventHandler;
import com.etlsolutions.gwise.presentation.palette.PlantTypeMouseDragEventHandler;
import com.etlsolutions.gwise.presentation.palette.MousePressEventHandler;
import com.etlsolutions.gwise.presentation.palette.PalettePropertyChangeAdapter;
import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.editor.DesignTabStatusManager;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * The PaletteController class controls the palette scene.
 *
 * @author zc
 */
public class PaletteController extends AbstractFXMLController {

    @FXML
    private AnchorPane paletteAnchorPane;

    @FXML
    private HBox plantBedHbox; //Add different shape images

    @FXML
    private HBox raisedPlantBedHbox;

    @FXML
    private HBox lawnHbox;

    @FXML
    private HBox pondHbox;

    @FXML
    private HBox greenhouseAndContainterHbox;

    @FXML
    private HBox roomHbox;


    @FXML
    private TilePane plantTilePane;
    
    @Override
    public void initializeComponents() {
        try {
            ValueWrapper<Tab> wrapper = DesignTabStatusManager.getInstance().getWrapper();
            paletteAnchorPane.setVisible(wrapper.getValue() != null);
            wrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PalettePropertyChangeAdapter(paletteAnchorPane));

            ValueWrapper<ProjectContents> cwrapper = ProjectManager.getInstance().getContentsValueWrapper();
            ProjectContents cvalue = cwrapper.getValue();
            ProjectContentsPalettePropertyChangeAdaper adapter = new ProjectContentsPalettePropertyChangeAdaper(plantTilePane);
            adapter.process(cvalue);
            cwrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, adapter);

            addImageView(plantBedHbox, PlantBedImageType.values());
            addImageView(raisedPlantBedHbox, RaisedPlantBedImageType.values());
            addImageView(lawnHbox, LawnImageType.values());            
            addImageView(pondHbox, PondImageType.values());
            addImageView(greenhouseAndContainterHbox, GreenhouseImageType.values());    
            addImageView(roomHbox, RoomImageType.values());
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

    private void addImageView(HBox box, ImageType[] types) throws FileNotFoundException {
        
        List<Node> logos = box.getChildren();
        
        for (ImageType type : types) {
            
            ImageView view = new ParameterisedImageView(new Image(new FileInputStream(new File(type.getFilePath()))), type.getSubAreaType(), type.getSubAreaType());
            
            view.setOnMousePressed(new MousePressEventHandler());
            view.setOnMouseReleased(new MouseReleaseEventHandler());
//            view.setOnMouseDragged(new PlantTypeMouseDragEventHandler());
            view.setOnDragDetected(new DragDetectedEventHandler());
            view.setOnDragDone(new DragDoneEventHandler());
            logos.add(view);
        }
    }
}
