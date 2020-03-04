package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
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
public class ViewTabChangeAdapter implements ChangeListener<Tab> {

    private final ValueWrapper<DataUnit> dataUnitValueWrapper = ProjectManager.getInstance().getSelectedDataUnitValueWrapper();

    @Override
    public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {

        TreeView<DataUnit> view = getTreeView(newValue.getContent());
        
        TreeItem<DataUnit> item = view.getSelectionModel().getSelectedItem();

        dataUnitValueWrapper.setValue(item == null ? null : item.getValue());
    }
    
    private TreeView<DataUnit> getTreeView(Node node) {
        
        if(node instanceof TreeView) {
            return (TreeView<DataUnit>) node;
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
