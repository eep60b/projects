package com.etlsolutions.javafx.presentation.view.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.presentation.view.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
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
                children.add(new AreaTreeItem(area));
        }
        
        areas.addListener(new DataUnitListChangeAdapter<Area>(children));
    }
}
