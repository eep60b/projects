package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.data.plant.PlantsGroupRoot;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class PlantsGroupRootTreeItem extends TreeItem<DataUnit> {

  public final PlantsGroupRoot root = PlantsFactory.createPlantsGroupRoot();
}
