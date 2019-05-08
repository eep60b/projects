package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.model.DesignPaneDataModel;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.PolygonMeasurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * EditorPropertyChangeAdapter instances listen to the change to the current
 * DataUnit object for the editor contents.
 *
 * @author zc
 */
public class EditorPropertyChangeAdapter implements PropertyChangeListener {

    private final DesignPaneDataModel model;
    private final ObservableList<Tab> tabs;
    private final TextArea informationTextArea;
    private final TilePane imageTilePane;
    private final Tab designTab;
    private final Tab areaRootTab = new Tab();
    private final StackPane designPane;
    private final ProjectManager manager = ProjectManager.getInstance();

    public EditorPropertyChangeAdapter(DesignPaneDataModel model, TabPane editorTabPane, TextArea informationTextArea, TilePane imageTilePane, Tab designTab, StackPane designPane) {

        this.model = model;
        tabs = editorTabPane.getTabs();
        this.informationTextArea = informationTextArea;
        this.imageTilePane = imageTilePane;
        this.designTab = designTab;
        Pane areaRootPane = new Pane();
        areaRootPane.getChildren().add(new Button("Add an area"));
        areaRootTab.setContent(areaRootPane);
        this.designPane = designPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        process((ValueWrapper<DataUnit>) evt.getSource());
    }

    public void process(ValueWrapper<DataUnit> wrapper) {

        imageTilePane.getChildren().clear();
        designPane.getChildren().clear();

        DataUnit data = wrapper.getValue();

        if (data == null) {
            tabs.clear();
            return;
        }

        informationTextArea.setText(data.displayMessage());

        for (ImageLink link : data.getImageLinks()) {
            imageTilePane.getChildren().add(new ImageView(new Image(link.getLink())));
        }

        Button addImageButton = new Button("+");
        addImageButton.setOnAction(new AddImageToDataUnitEventHandler());
        imageTilePane.getChildren().add(addImageButton);
        data.addListener(DataUnit.DESCRIPTION_PROPERTY, new EditorDescriptionChangeAdapter(data, informationTextArea));
        data.getImageLinks().addListener(new EditorImageLinksAdapter(data, imageTilePane));
        
        if(data instanceof AreaRoot) {
            
            if(tabs.size() == 1 && tabs.contains(areaRootTab)){
                return;
            }
            
            tabs.clear();
            tabs.add(areaRootTab);
        }
        else if (data instanceof Area) {
            drawArea((Area) data);
        } else if (data instanceof SubArea) {
            drawSubArea((SubArea) data);
        } else if (data instanceof Location) {
            drawLocation((Location) data);
        } else if (data instanceof Plants) {

            drawPlants((Plants) data);

        } else {
            tabs.remove(designTab);
        }
    }

    private StackPane drawArea(Area area) {

        if (!tabs.contains(designTab)) {
            tabs.add(designTab);
        }

        StackPane areaPane = new StackPane();
        areaPane.setPrefSize(area.getOcuppiedWidth(), area.getOccuppiedHeight());
        designPane.getChildren().add(areaPane);
        areaPane.relocate(area.getCenterX(), area.getCenterY());

        switch (area.getMeasurement().getType()) {

            case RECTANGLE:
                RectangleMeasurement m = (RectangleMeasurement) area.getMeasurement();
                Rectangle r = new Rectangle(m.getWidth(), m.getLength());
                areaPane.getChildren().add(r);
                r.relocate(area.getCenterX(), area.getCenterY());
                r.setOnMousePressed(new MousePressedEventHandler(model));
                r.setOnMouseDragged(new MouseDraggedEventHandler(model));
                r.setOnMouseClicked(new MouseClickedEventHandler(area));
                break;
            case CIRCLE:
                Circle c = new Circle(area.getCenterX(), area.getCenterY(), ((CircleMeasurement) area.getMeasurement()).getDiameter() / 2);
                areaPane.getChildren().add(c);
                c.relocate(area.getCenterX(), area.getCenterY());
                c.setOnMousePressed(new MousePressedEventHandler(model));
                c.setOnMouseDragged(new MouseDraggedEventHandler(model));
                c.setOnMouseClicked(new MouseClickedEventHandler(area));
                break;
            case POLYGON:
                Polygon p = new Polygon(((PolygonMeasurement) area.getMeasurement()).getCoordinates());
                p.setOnMousePressed(new MousePressedEventHandler(model));
                p.setOnMouseDragged(new MouseDraggedEventHandler(model));
                p.setOnMouseClicked(new MouseClickedEventHandler(area));
                areaPane.getChildren().add(p);
                p.relocate(area.getCenterX(), area.getCenterY());
                break;
            default:
                throw new IllegalStateException("Invaid area type.");
        }

        return areaPane;
    }

    private void drawSubArea(SubArea subArea) {

        StackPane areaPane = drawArea((Area) manager.getItem(subArea.getParentId()));
        areaPane.setDisable(true);

        //TODO: 1. hide the rest area. 2. Add another StackPane. Set the size to the maxium it can reach. 3. Add the contents (Location and plants).
    }

    private void drawLocation(Location location) {
        drawSubArea((SubArea) manager.getItem(location.getParentId()));

        //TODO: hide the rest area.
    }

    private void drawPlants(Plants plants) {

        Location location = (Location) manager.getItem(plants.getLocationId());
        drawLocation(location);

        //TODO: hide the rest area.
    }
}
