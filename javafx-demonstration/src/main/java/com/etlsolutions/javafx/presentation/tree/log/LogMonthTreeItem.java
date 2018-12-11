package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogMonth;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;

/**
 *
 * @author zc
 */
public class LogMonthTreeItem extends MenuedTreeItem {
    
    public LogMonthTreeItem(LogMonth value) {
        super(value);
        for(Log log : value.getLogs()) {
            getChildren().add(new LogTreeItem(log));
        }        
    }    
}
