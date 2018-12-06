package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.gvent.AddGventDataModel;
import com.etlsolutions.javafx.system.ProjectContents;
import javafx.scene.control.MenuItem;

/**
 *
 * @author zc
 */
public class AddGventPropertyChangeAdapter extends AbstractMenuItemPropertyChangeAdapter {

    public AddGventPropertyChangeAdapter(MenuItem item, ValueWrapper<ProjectContents> wrapper) {
        super(item, wrapper);
    }

    @Override
    protected void processItem(MenuItem item) {
        item.setOnAction(new FXMLActionEventHandler<>(new AddGventDataModel()));
    }
}
