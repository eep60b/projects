package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author zc
 */
/**
 *
 * @author zc
 * @param <P> - The parent parentModel;
 * @param <T> - The data unit type.
 * @param <M> - The parentModel for nodeWrapper;
 * 
 */
public class NodeGenerator <P extends FXMLContentActionDataModel, T> {

    private final P parentModel;
    private final Map<T, NodeWrapper> map;

    public NodeGenerator(P parentModel, Map<T, NodeWrapper> map) {
        this.parentModel = parentModel;
        this.map = map;
    }

    public Node getNode(T type) {
        try {
            NodeWrapper nodeWrapper = map.get(type);

            if (nodeWrapper == null) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource(parentModel.getFxmlPath()));
                AnchorPane node = (AnchorPane) loader.load();
                AbstractComponentsFXMLController controller = loader.getController();
                
                controller.setModel(parentModel.getContentModel());
                controller.initializeComponents();
                nodeWrapper = new NodeWrapper(type, node);
                map.put(type, nodeWrapper);
            }

            return nodeWrapper.getNode();
        } catch (Exception ex) {
            throw new CustomLevelErrorRuntimeExceiption("Cannot find node.", ex);
        }
    }

}
