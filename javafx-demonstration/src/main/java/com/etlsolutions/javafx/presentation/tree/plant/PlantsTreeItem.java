package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.Plants;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
class PlantsTreeItem extends TreeItem<DataUnit> {

    private final Plants model;

    public PlantsTreeItem(Plants model) {
        super(model);
        this.model = model;
        
    }
}
