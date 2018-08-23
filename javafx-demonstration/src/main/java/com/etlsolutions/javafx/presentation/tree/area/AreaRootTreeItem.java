package com.etlsolutions.javafx.presentation.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.AllotmentArea;
import com.etlsolutions.javafx.data.area.AreaRoot;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class AreaRootTreeItem extends TreeItem<DataUnit>{

    private final AreaRoot model;

    public AreaRootTreeItem(AreaRoot model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();
        for(AllotmentArea area : model.getAllotmentAreas()) {
            if(area.isEmpty()) {
                
            }
        }
    }
    
    
}
