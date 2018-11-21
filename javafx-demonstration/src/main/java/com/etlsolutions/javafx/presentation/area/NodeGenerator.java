package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.presentation.AbstractComponentsFXMLController;
import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author zc
 */
public class NodeGenerator {

    private final MeasurementWrappable model;
    private final Map<MeasurementType, Node> map;

    public NodeGenerator(MeasurementWrappable model, Map<MeasurementType, Node> map) {
        this.model = model;
        this.map = map;
    }

    public Node getNode(MeasurementType type) {
        try {
            Node node = map.get(type);

            if (node == null) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource(model.getMeasurementDataModelValueWrapper().getValue().getFxmlPath()));
                node = (AnchorPane) loader.load();
                AbstractComponentsFXMLController<MeasurementDataModel> controller = loader.getController();
                controller.setModel(model.getMeasurementDataModelValueWrapper().getValue());
                controller.initializeComponents();
                map.put(type, node);
            }

            return node;
        } catch (Exception ex) {
            throw new CustomLevelErrorRuntimeExceiption("Cannot find node.", ex);
        }
    }

}
