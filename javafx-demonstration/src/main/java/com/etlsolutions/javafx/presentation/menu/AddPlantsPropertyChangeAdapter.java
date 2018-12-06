package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plant.AddPlantDataModel;
import com.etlsolutions.javafx.system.ProjectContents;
import java.beans.PropertyChangeEvent;
import javafx.scene.control.MenuItem;

/**
 *
 * @author zc
 */
public class AddPlantsPropertyChangeAdapter extends AbstractMenuItemPropertyChangeAdapter {

    public AddPlantsPropertyChangeAdapter(MenuItem item, ValueWrapper<ProjectContents> wrapper) {
        super(item, wrapper);
    }

    @Override
    protected void processItem(MenuItem item) {
        item.setOnAction(new FXMLActionEventHandler<>(new AddPlantDataModel()));
    }
}
