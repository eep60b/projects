package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.log.gvent.Gvent;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class EditGventDataModel extends AbstractGventDataModel {

    public EditGventDataModel(Gvent gvent) {
        super(gvent);
    }

    @Override
    public void save() {
       
        Gvent gvent = getItem();
        gvent.setCommonValues(getValueWrapper());
        gvent.setEndTime(getEndTimeValueWrapper().getValue());
        gvent.setModifiedTime(LocalDateTime.now());
        gvent.setStartTime(getStartTimeValueWrapper().getValue());
        support.firePropertyChange(LIST_CHANGE_PROPERTY, true, false);        
    }
}
