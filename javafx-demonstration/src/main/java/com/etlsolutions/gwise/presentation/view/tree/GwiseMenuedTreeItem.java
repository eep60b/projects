package com.etlsolutions.gwise.presentation.view.tree;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class GwiseMenuedTreeItem extends TreeItem<GwiseDataUnit> {
    
    private ContextMenu contextMenu;

    public GwiseMenuedTreeItem() {
    }

    public GwiseMenuedTreeItem(GwiseDataUnit value) {
        super(value);
    }
    
    public GwiseMenuedTreeItem(ContextMenu contextMenu, GwiseDataUnit value) {
        super(value);
        this.contextMenu = contextMenu;
    }
        
    public ContextMenu getContextMenu() {
        return contextMenu;
    }

    public void setContextMenu(ContextMenu contextMenu) {
        this.contextMenu = contextMenu;
    }    
}
