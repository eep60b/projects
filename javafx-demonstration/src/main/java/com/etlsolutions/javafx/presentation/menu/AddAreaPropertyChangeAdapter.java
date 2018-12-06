/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.AddAreaDataModel;
import com.etlsolutions.javafx.system.ProjectContents;
import javafx.scene.control.MenuItem;

/**
 *
 * @author zc
 */
public class AddAreaPropertyChangeAdapter extends AbstractMenuItemPropertyChangeAdapter {

    public AddAreaPropertyChangeAdapter(MenuItem item, ValueWrapper<ProjectContents> wrapper) {
        super(item, wrapper);
    }

    @Override
    protected void processItem(MenuItem item) {
        item.setOnAction(new FXMLActionEventHandler<>(new AddAreaDataModel()));
    }
}
