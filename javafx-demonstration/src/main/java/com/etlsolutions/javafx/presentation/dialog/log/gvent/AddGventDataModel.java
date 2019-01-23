package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGventDataModel extends AbstractGventDataModel {

    @Override
    public void save() {
        set(LogFactory.getInstance().createGvent(getValueWrapper(), detailDataModel.getDetail()));
        ProjectManager.getInstance().getContents().getLogGroupRoot().getGvents().addLog(get());
    }
}
