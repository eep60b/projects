package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.Log;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogTreeItem extends TreeItem<DataUnit>{
    
    public LogTreeItem(Log model) {
        super(model);
        
    }    
}
