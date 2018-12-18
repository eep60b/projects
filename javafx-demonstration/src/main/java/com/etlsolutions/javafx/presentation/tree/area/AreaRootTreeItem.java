package com.etlsolutions.javafx.presentation.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.presentation.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class AreaRootTreeItem extends MenuedTreeItem {

    public AreaRootTreeItem(AreaRoot root) {

        super(root);

        List<TreeItem<DataUnit>> children = getChildren();

        ObservableListWrapperA<Area> areas = root.getAreas();
        
        for (Area area : areas) {
            if (!area.getAllSubAreas().isEmpty()) {
                children.add(new AreaTreeItem(area));
            }
        }
        
        areas.addListener(new DataUnitListChangeAdapter<Area>(children));
    }
}
