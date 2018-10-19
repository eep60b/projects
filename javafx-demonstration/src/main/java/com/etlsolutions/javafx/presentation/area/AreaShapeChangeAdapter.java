package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author zc
 */
public class AreaShapeChangeAdapter implements ChangeListener<AreaShape> {

    private final AbstractAreaDataModel model;
    private final AreaMeasurementDataModel measurementModel;
    private final Tab measurementTab;
    private final Node rectanglePane;
    private final Node squrePane;
    private final Node circlePane;
    private final Node trianglePane;
    private final Node irregularPane;

    public AreaShapeChangeAdapter(AbstractAreaDataModel model, AreaMeasurementDataModel measurementDataModel, Tab measurementTab) {
        this.model = model;
        this.measurementModel = measurementDataModel;
        this.measurementTab = measurementTab;
        rectanglePane = getNode(AreaShape.RECTANGLE);
        squrePane = getNode(AreaShape.SQURE);
        circlePane = getNode(AreaShape.CIRCLE);
        trianglePane = getNode(AreaShape.TRIANGLE);
        irregularPane = getNode(AreaShape.IRREGULAR);
    }

    @Override
    public void changed(ObservableValue<? extends AreaShape> observable, AreaShape oldValue, AreaShape newValue) {


        if (oldValue == newValue) {
            return;
        }

        model.setSelectedAreaShape(newValue);

        switch (newValue) {
            case RECTANGLE:
                measurementTab.setContent(rectanglePane);
                return;
            case SQURE:
                measurementTab.setContent(squrePane);
                return;
            case CIRCLE:
                measurementTab.setContent(circlePane);
                return;
            case TRIANGLE:
                measurementTab.setContent(trianglePane);
                return;
            case IRREGULAR:
                measurementTab.setContent(irregularPane);
                return;
        }
        throw new IllegalStateException("Invalid shape.");
    }

    private Node getNode(AreaShape shape) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(measurementModel.getFxmlPath(shape)));
            Node node = (AnchorPane) loader.load();
            AbstractComponentsFXMLController<AreaMeasurementDataModel> controller = loader.getController();
            controller.setModel(measurementModel);
            controller.initializeComponents();
            return node;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
