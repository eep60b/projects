package com.etlsolutions.javafx.presentation.tree.plant;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class PlantsTreeView extends TreeView<DataUnit> {

  private final PlantsGroupRootTreeItem root = new PlantsGroupRootTreeItem();
  
  public PlantsTreeView() { 
    super.setRoot(root);
    super.setShowRoot(false);
  }
  
}
