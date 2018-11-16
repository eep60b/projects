package com.etlsolutions.javafx.presentation.tree;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class MenuedTreeItem extends TreeItem<DataUnit> {
    
    private ContextMenu contextMenu;

    public MenuedTreeItem() {
    }

    public MenuedTreeItem(DataUnit value) {
        super(value);
    }
    
    public MenuedTreeItem(ContextMenu contextMenu, DataUnit value) {
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
