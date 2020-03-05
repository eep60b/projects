package com.etlsolutions.gwise.presentation.view;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.ProjectManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

/**
 * The ViewTabChangeAdapter class is a listener class which listens to the tab
 * change in the view panel and set the corresponding data to the project manager.
 *
 * @author zc
 */
public class GwiseViewTabChangeAdapter implements ChangeListener<Tab> {

    private final ValueWrapper<GwiseDataUnit> dataUnitValueWrapper = ProjectManager.getInstance().getSelectedGwiseDataUnitValueWrapper();

    @Override
    public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {

        TreeView<GwiseDataUnit> view = getTreeView(newValue.getContent());
        
        TreeItem<GwiseDataUnit> item = view.getSelectionModel().getSelectedItem();

        dataUnitValueWrapper.setValue(item == null ? null : item.getValue());
    }
    
    private TreeView<GwiseDataUnit> getTreeView(Node node) {
        
        if(node instanceof TreeView) {
            return (TreeView<GwiseDataUnit>) node;
        }
        
        if(node instanceof AnchorPane) {
            return getTreeView(((AnchorPane)node).getChildren().get(0));
        }
        
        if(node instanceof SplitPane) {
            return getTreeView(((SplitPane)node).getItems().get(0));
        }
        
        throw new IllegalArgumentException("Invalid node");
    }
}
