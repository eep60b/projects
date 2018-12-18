package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.LogGroup;
import com.etlsolutions.javafx.data.log.LogYear;
import com.etlsolutions.javafx.presentation.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class LogGroupTreeItem extends MenuedTreeItem {

    public LogGroupTreeItem(LogGroup group) {
        
        super(group);
        
        List<TreeItem<DataUnit>> children = getChildren();        
        ObservableListWrapperA<LogYear> years = group.getYears();
        for (LogYear year : years) {
            children.add(new LogYearTreeItem(year));
        }

        years.addListener(new DataUnitListChangeAdapter<LogYear>(children));
    }
}
