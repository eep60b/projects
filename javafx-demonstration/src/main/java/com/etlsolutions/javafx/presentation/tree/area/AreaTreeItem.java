package com.etlsolutions.javafx.presentation.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class AreaTreeItem extends MenuedTreeItem {

    public AreaTreeItem(Area area) {

        super(area);
        List<TreeItem<DataUnit>> children = getChildren();
        ObservableListWrapperA<SubArea> subAreas = area.getSubAreas();
        
        for(SubArea subArea : subAreas) {
            children.add(new SubAreaTreeItem(subArea));
        }

        subAreas.addListener(new DataUnitListChangeAdapter<SubArea>(children));
    }
}
