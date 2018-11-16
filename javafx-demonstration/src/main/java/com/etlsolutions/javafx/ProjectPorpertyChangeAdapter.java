package com.etlsolutions.javafx;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.etlsolutions.javafx.presentation.tree.plant.PlantsGroupRootTreeItem;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 */
public class ProjectPorpertyChangeAdapter implements PropertyChangeListener {

    private final TreeItem<DataUnit> item;

    public ProjectPorpertyChangeAdapter(TreeItem<DataUnit> item) {
        this.item = item;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ProjectManager manager = (ProjectManager) evt.getSource();

        ProjectContents c = manager.getContents();
        PlantGroupRoot r = c == null ? null :  c.getPlantsGroupRoot();
        item.setValue(r);
    }
}
