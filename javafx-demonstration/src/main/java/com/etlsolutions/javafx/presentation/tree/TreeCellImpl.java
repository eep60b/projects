package com.etlsolutions.javafx.presentation.tree;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.scene.control.TreeCell;

/**
 *
 * @author zc
 */
public class TreeCellImpl extends TreeCell<DataUnit> {

    @Override
    public void updateItem(DataUnit item, boolean empty) {
        
        super.updateItem(item, empty);
        
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(getItem() == null ? "" : getItem().getTitle());
            setGraphic(getTreeItem().getGraphic());
            setContextMenu(((MenuedTreeItem) getTreeItem()).getContextMenu());
        }
    }
}