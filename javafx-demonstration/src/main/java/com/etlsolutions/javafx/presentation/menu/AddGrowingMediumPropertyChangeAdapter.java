package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.system.ProjectContents;
import javafx.scene.control.MenuItem;

/**
 *
 * @author zc
 */
public class AddGrowingMediumPropertyChangeAdapter extends AbstractMenuItemPropertyChangeAdapter {

    public AddGrowingMediumPropertyChangeAdapter(MenuItem item, ValueWrapper<ProjectContents> wrapper) {
        super(item, wrapper);
    }

    @Override
    protected void processItem(MenuItem item) {
        item.setOnAction(new FXMLActionEventHandler<>(new AddGrowingMediumDataModel()));
    }
}
