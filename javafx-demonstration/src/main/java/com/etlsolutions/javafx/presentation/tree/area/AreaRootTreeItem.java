package com.etlsolutions.javafx.presentation.tree.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.AllotmentArea;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.area.BalconyArea;
import com.etlsolutions.javafx.data.area.CustomArea;
import com.etlsolutions.javafx.data.area.FarmArea;
import com.etlsolutions.javafx.data.area.GardenArea;
import com.etlsolutions.javafx.data.area.IndoorArea;
import com.etlsolutions.javafx.data.area.PatioArea;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class AreaRootTreeItem extends TreeItem<DataUnit> {

    private final AreaRoot model;

    public AreaRootTreeItem(AreaRoot model) {
        super(model);
        this.model = model;
        List<TreeItem<DataUnit>> children = getChildren();

        for (GardenArea area : model.getGardenAreas()) {
            if (!area.isEmpty()) {
                children.add(new GardenAreaTreeItem(area));
            }
        }

        for (PatioArea area : model.getPatioAreas()) {

        }

        for (IndoorArea area : model.getIndoorAreas()) {

        }

        for (AllotmentArea area : model.getAllotmentAreas()) {
            if (!area.isEmpty()) {
                children.add(new AllotmentAreaTreeItem(area));
            }
        }

        for (BalconyArea area : model.getBalconyAreas()) {

        }

        for (FarmArea area : model.getFarmAreas()) {

        }

        for (CustomArea area : model.getCustomAreas()) {

        }
    }

}
