package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogGroup;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;

/**
 *
 * @author zc
 */
public class LogGroupTreeItem extends MenuedTreeItem {
    
    public LogGroupTreeItem(LogGroup value) {
        super(value);
        
        
        for(Log log : value.getLogs()) {
            getChildren().add(new LogTreeItem(log));
        }
       
        
    }    
}
