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
public abstract class AbstractMenuItemPropertyChangeAdapter implements PropertyChangeListener {

    private final MenuItem item;
    private final ValueWrapper<ProjectContents> wrapper;

    public AbstractMenuItemPropertyChangeAdapter(MenuItem item, ValueWrapper<ProjectContents> wrapper) {
        this.item = item;
        this.wrapper = wrapper;
        process();
    }

    protected abstract void processItem(MenuItem item);

    private void process() {

        boolean hasNoContents = wrapper.getValue() == null;
        item.setDisable(hasNoContents);
        if (hasNoContents) {
            return;
        }
        processItem(item);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process();
    }
}
