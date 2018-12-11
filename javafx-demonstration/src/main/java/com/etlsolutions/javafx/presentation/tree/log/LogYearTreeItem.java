package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.log.LogMonth;
import com.etlsolutions.javafx.data.log.LogYear;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;

/**
 *
 * @author zc
 */
public class LogYearTreeItem extends MenuedTreeItem {
    
    public LogYearTreeItem(LogYear value) {
        super(value);
        for(LogMonth log : value.getMonths()) {
            getChildren().add(new LogMonthTreeItem(log));
        }        
    }    
}
