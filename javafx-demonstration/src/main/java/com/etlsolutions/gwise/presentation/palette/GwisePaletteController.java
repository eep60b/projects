package com.etlsolutions.gwise.presentation.palette;

import com.etlsolutions.gwise.AbstractFXMLController;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.subarea.GwiseSubAreaType;
import com.etlsolutions.gwise.data.subarea.SubareaLogoItem;
import com.etlsolutions.gwise.presentation.ParameterisedImageView;
import com.etlsolutions.javafx.presentation.palette.ImageViewDragDetectedEventHandler;
import com.etlsolutions.javafx.presentation.palette.ImageViewDragDoneEventHandler;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.gwise.system.GwiseProjectContents;
import com.etlsolutions.gwise.system.ProjectManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
public class GwisePaletteController extends AbstractFXMLController {

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

            ValueWrapper<GwiseProjectContents> cwrapper = ProjectManager.getInstance().getGwiseProjectContentsWrapper();
            GwiseProjectContents projectContents = cwrapper.getValue();
            GwiseProjectContentsPalettePropertyChangeAdaper adapter = new GwiseProjectContentsPalettePropertyChangeAdaper(plantTilePane);
            adapter.process(projectContents);
            cwrapper.addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, adapter);

            addImageView(plantBedHbox, GwiseSubAreaType.PLANT_BED, projectContents);
            addImageView(raisedPlantBedHbox, GwiseSubAreaType.RAISED_PLANT_BED, projectContents);
            addImageView(lawnHbox, GwiseSubAreaType.LAWN, projectContents);            
            addImageView(pondHbox, GwiseSubAreaType.POND, projectContents);
            addImageView(greenhouseAndContainterHbox, GwiseSubAreaType.GREEN_HOUSE, projectContents); 
            addImageView(roomHbox, GwiseSubAreaType.ROOM, projectContents);
            
        } catch (FileNotFoundException ex) {
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

    private void addImageView(HBox box, GwiseSubAreaType subAreaType, GwiseProjectContents projectContents) throws FileNotFoundException {
        
        List<Node> logos = box.getChildren();
        
        List<SubareaLogoItem> logoItems = projectContents.getSubareaLogoItems().get(subAreaType);
                
        for (SubareaLogoItem item : logoItems) {
            
            ImageView view = new ParameterisedImageView(new Image(new FileInputStream(new File(item.getLogoPath()))), item);
            
            view.setOnMousePressed(new MousePressEventHandler());
            view.setOnMouseReleased(new MouseReleaseEventHandler());
            view.setOnMouseDragged(new MouseDragEventHandler());
            view.setOnDragDetected(new ImageViewDragDetectedEventHandler());
            view.setOnDragDone(new ImageViewDragDoneEventHandler());
            logos.add(view);
        }
    }
}
