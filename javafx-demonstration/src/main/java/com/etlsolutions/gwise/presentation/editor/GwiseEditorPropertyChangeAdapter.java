package com.etlsolutions.gwise.presentation.editor;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.PropertyChangeAdapter;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.presentation.editor.designtab.GwiseDesignPaneDataModel;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.area.GwiseAreaRoot;
import com.etlsolutions.gwise.data.locations.GwiseLocationSet;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

/**
 * EditorPropertyChangeAdapter instances listen to the change to the current selected
 * DataUnit object in the tree view for the editor contents.
 *
 * @author zc
 */
public class GwiseEditorPropertyChangeAdapter extends PropertyChangeAdapter {

    private final GwiseDesignPaneDataModel model;
    private final ObservableList<Tab> tabs;
    private final TextArea informationTextArea;
    private final TilePane imageTilePane;
    private final Tab designTab;
    private final Tab areaRootTab = new Tab();
    private final StackPane designPane;
    private final ProjectManager manager = ProjectManager.getInstance();

    public GwiseEditorPropertyChangeAdapter(GwiseDataUnit unit, GwiseDesignPaneDataModel model, TabPane editorTabPane, TextArea informationTextArea, TilePane imageTilePane, Tab designTab, StackPane designPane) {

        super(unit);
        this.model = model;
        tabs = editorTabPane.getTabs();
        this.informationTextArea = informationTextArea;
        this.imageTilePane = imageTilePane;
        this.designTab = designTab;
        Pane areaRootPane = new Pane();
        areaRootTab.setContent(areaRootPane);
        this.designPane = designPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        process((ValueWrapper<GwiseDataUnit>) evt.getSource());
    }

    public void process(ValueWrapper<GwiseDataUnit> wrapper) {

        imageTilePane.getChildren().clear();
        designPane.getChildren().clear();

        GwiseDataUnit data = wrapper.getValue();

        if (data == null) {
            tabs.clear();
            return;
        }

        informationTextArea.setText(data.getInformation());

        for (ImageLink link : data.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }

        Button addImageButton = new Button("+");
        addImageButton.setOnAction(new GwiseAddImageToDataUnitEventHandler());
        imageTilePane.getChildren().add(addImageButton);
        data.getInformationWrapper().addNonDuplicatedDataUnitPropertyChangeAdapter(ValueWrapper.VALUE_CHANGE, new GwiseEditorDescriptionChangeAdapter(data, informationTextArea));
        
        ObservableListWrapperA<ImageLink> list = data.getImageLinks();        
        list.addListener(new GwiseEditorImageLinksAdapter(list, imageTilePane));
        
        if(data instanceof GwiseAreaRoot) {
            
            if(tabs.size() == 1 && tabs.contains(areaRootTab)){
                return;
            }
            
            tabs.clear();
            tabs.add(areaRootTab);
        } else if (data instanceof GwiseArea) {
            drawArea((GwiseArea) data);
        } else if (data instanceof GwiseSubarea) {
            drawSubArea((GwiseSubarea) data);
        } else if (data instanceof GwiseLocationSet) {
            drawLocation((GwiseLocationSet) data);
        } else if (data instanceof GwisePlantGroup) {

           // drawPlants((Plants) data);

        } else {
            tabs.remove(designTab);
        }
    }

    private StackPane drawArea(GwiseArea area) {

        if (!tabs.contains(designTab)) {
            tabs.add(designTab);
        }

        StackPane areaPane = new StackPane();
//        areaPane.setPrefSize(area.getOcuppiedWidth(), area.getOccuppiedHeight());
//        designPane.getChildren().add(areaPane);
//        areaPane.relocate(area.getCenterX(), area.getCenterY());
//
//        switch (area.getMeasurement().getType()) {
//
//            case RECTANGLE:
//                RectangleMeasurement m = (RectangleMeasurement) area.getMeasurement();
//                Rectangle r = new Rectangle(m.getWidth(), m.getLength());
//                areaPane.getChildren().add(r);
//                r.relocate(area.getCenterX(), area.getCenterY());
//                r.setOnMousePressed(new MousePressedEventHandler(model));
//                r.setOnMouseDragged(new MouseDraggedEventHandler(model));
//                r.setOnMouseClicked(new MouseClickedEventHandler(area));
//                break;
//            case CIRCLE:
//                Circle c = new Circle(area.getCenterX(), area.getCenterY(), ((CircleMeasurement) area.getMeasurement()).getDiameter() / 2);
//                areaPane.getChildren().add(c);
//                c.relocate(area.getCenterX(), area.getCenterY());
//                c.setOnMousePressed(new MousePressedEventHandler(model));
//                c.setOnMouseDragged(new MouseDraggedEventHandler(model));
//                c.setOnMouseClicked(new MouseClickedEventHandler(area));
//                break;
//            case POLYGON:
//                Polygon p = new Polygon(((PolygonMeasurement) area.getMeasurement()).getCoordinates());
//                p.setOnMousePressed(new MousePressedEventHandler(model));
//                p.setOnMouseDragged(new MouseDraggedEventHandler(model));
//                p.setOnMouseClicked(new MouseClickedEventHandler(area));
//                areaPane.getChildren().add(p);
//                p.relocate(area.getCenterX(), area.getCenterY());
//                break;
//            default:
//                throw new IllegalStateException("Invaid area type.");
      //  }

        return areaPane;
    }

    private void drawSubArea(GwiseSubarea subArea) {

        StackPane areaPane = drawArea(subArea.getParent());
        areaPane.setDisable(true);

        //TODO: 1. hide the rest area. 2. Add another StackPane. Set the size to the maxium it can reach. 3. Add the contents (Location and plants).
    }

    private void drawLocation(GwiseLocationSet location) {
        drawSubArea((location.getParent().getParent()));

        //TODO: hide the rest area.
    }

    private void drawPlants(Plants plants) {

        Location location = (Location) manager.getItem(plants.getLocationId());
   //     drawLocation(location);

        //TODO: hide the rest area.
    }
}
