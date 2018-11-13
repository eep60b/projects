package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGventDataModel extends AbstractGventDataModel {

    @Override
    public void save() {
        ProjectManager.getInstance().getContents().getFlowerTypes();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
