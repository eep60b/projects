package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.LogMonth;
import com.etlsolutions.javafx.data.log.LogYear;
import com.etlsolutions.javafx.presentation.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogYearTreeItem extends MenuedTreeItem {
    
    public LogYearTreeItem(LogYear year) {
        
        super(year);
        List<TreeItem<DataUnit>> children = getChildren();        
        ObservableListWrapperA<LogMonth> months = year.getMonths();
        for (LogMonth month : months) {
            children.add(new LogMonthTreeItem(month));
        }
        months.addListener(new DataUnitListChangeAdapter<>(children));      
    }    
}
