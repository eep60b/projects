package com.etlsolutions.javafx.presentation;

import com.etlsolutions.gwise.presentation.FXMLContentActionDataModel;
import com.etlsolutions.gwise.system.CustomLevelErrorRuntimeExceiption;
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
 * 
 */
public class NodeGenerator <P extends FXMLContentActionDataModel, T> {

    private final P parentModel;
    private final Map<T, NodeWrapper> map;

    public NodeGenerator(P parentModel, Map<T, NodeWrapper> map) {
        this.parentModel = parentModel;
        this.map = map;
    }

    public NodeWrapper getNode(T type) {
        try {
            NodeWrapper nodeWrapper = map.get(type);

            if (nodeWrapper == null) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource(parentModel.getContentModel().getFxmlPath()));
                AnchorPane node = (AnchorPane) loader.load();
                AbstractComponentsFXMLController controller = loader.getController();
                
                controller.setModel(parentModel.getContentModel());
                controller.initializeComponents();
                nodeWrapper = new NodeWrapper(parentModel.getContentModel(), node);
                map.put(type, nodeWrapper);
            }

            return nodeWrapper;
        } catch (Exception ex) {
            throw new CustomLevelErrorRuntimeExceiption("Cannot find node.", ex);
        }
    }
}
