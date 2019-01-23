package com.etlsolutions.javafx.presentation.view;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class ViewTabsManager {
    
    private static final ViewTabsManager INSTANCE = new ViewTabsManager();

    private final Map<String, TreeView<DataUnit>> treeViewMap = new HashMap<>();
        
    private ViewTabsManager() {
    }
    
    public static ViewTabsManager getInstance() {
        return INSTANCE;
    }

    public Map<String, TreeView<DataUnit>> getTreeViewMap() {
        return treeViewMap;
    }    
}
