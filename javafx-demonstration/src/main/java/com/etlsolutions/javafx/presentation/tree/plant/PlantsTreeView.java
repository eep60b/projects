package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class PlantsTreeView extends TreeView<DataUnit> {

  public PlantsTreeView() { 
    super.setRoot(new PlantsGroupRootTreeItem());
    super.setShowRoot(false);
  }
  
}
