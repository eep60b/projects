/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.tree.log;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class LogsTreeView extends TreeView<DataUnit> {
    
    public void setModel(LogGroupRoot model) {
        LogGroupRootTreeItem root = new LogGroupRootTreeItem(model);
        setRoot(root);        
    }
}
