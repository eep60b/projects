package com.etlsolutions.gwise.presentation.view.tree;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import javafx.scene.control.TreeCell;

/**
 *
 * @author zc
 */
public class GwiseTreeCellImpl extends TreeCell<GwiseDataUnit> {

    @Override
    public void updateItem(GwiseDataUnit item, boolean empty) {
        
        super.updateItem(item, empty);
        
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(getItem() == null ? "" : getItem().getTitle());
            setGraphic(getTreeItem().getGraphic());
            setContextMenu(((GwiseMenuedTreeItem) getTreeItem()).getContextMenu());
        }
    }
}