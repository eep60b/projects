package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.log.LogGroup;
import com.etlsolutions.javafx.data.log.LogYear;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;

/**
 *
 * @author zc
 */
public class LogGroupTreeItem extends MenuedTreeItem {
    
    public LogGroupTreeItem(LogGroup group) {
        super(group);
        for(LogYear year : group.getYears()) {
            getChildren().add(new LogYearTreeItem(year));
        }        
    }    
}
