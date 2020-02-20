package com.etlsolutions.javafx.presentation.view.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.presentation.view.tree.DataUnitListChangeAdapter;
import com.etlsolutions.javafx.presentation.view.tree.MenuedTreeItem;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class SubAreaTreeItem extends MenuedTreeItem {

    public SubAreaTreeItem(SubArea subArea) {
        
        super(subArea);
        List<TreeItem<DataUnit>> children = getChildren();
        ObservableListWrapperA<Location> locations = subArea.getLocations();
        
        for(Location location : locations) {
            children.add(new LocationTreeItem(location));
        }
        
        locations.addListener(new DataUnitListChangeAdapter<>(children));        
        
    }
    
}
