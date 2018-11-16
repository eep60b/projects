package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddGrowingObservationDataModel extends AbstractGrowingObservationDataModel {

    @Override
    public void save() {
        dataUnit = LogFactory.getInstance().createGrowingObservation(endTime, endTime, startTime, title, information, imageLinks, 0, logoPath);
        ProjectManager.getInstance().getContents().getLogGroupRoot().getNotes().addLog(dataUnit);
    }
}
