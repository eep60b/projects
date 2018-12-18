package com.etlsolutions.javafx.presentation.tree;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.tree.area.AreaTreeItem;

/**
 *
 * @author zc
 */
public class DataUnitTreeItemFactory {

    private static final DataUnitTreeItemFactory INSTANCE = new DataUnitTreeItemFactory();

    private DataUnitTreeItemFactory() {
    }
    
    public static DataUnitTreeItemFactory getInstance() {
        return INSTANCE;
    }
    
    public MenuedTreeItem getTreeItem(DataUnit unit) {
        
        if(unit instanceof Area) {
            return new AreaTreeItem((Area)unit);
        }
          
        return null;
    }
}
