package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.MenuItem;

/**
 *
 * @author zc
 */
public class MenuItemPropertyChangeAdapter implements PropertyChangeListener {

    private final ValueWrapper<ProjectContents> wrapper;
    private final MenuItem[] items;

    public MenuItemPropertyChangeAdapter(ValueWrapper<ProjectContents> wrapper, MenuItem... items) {

        this.wrapper = wrapper;
        this.items = items;
        process();
    }

    private void process() {
        for (MenuItem item : items) {
            item.setDisable(wrapper.getValue() == null);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process();
    }
}
