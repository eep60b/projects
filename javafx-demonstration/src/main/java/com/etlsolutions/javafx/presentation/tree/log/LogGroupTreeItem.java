package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogGroup;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogGroupTreeItem extends TreeItem<DataUnit>{
    
    public LogGroupTreeItem(LogGroup value) {
        super(value);
        
        
        for(Log log : value.getLogs()) {
            getChildren().add(new LogTreeItem(log));
        }
       
        
    }    
}
