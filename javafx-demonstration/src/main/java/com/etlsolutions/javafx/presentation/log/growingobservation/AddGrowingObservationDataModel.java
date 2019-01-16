package com.etlsolutions.javafx.presentation.log.growingobservation;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingObservationDataModel extends AbstractGrowingObservationDataModel {

    @Override
    public void save() {
        set(LogFactory.getInstance().createGrowingObservation(getValueWrapper()));
        ProjectManager.getInstance().getContents().getLogGroupRoot().getNotes().addLog(get());
    }
}
