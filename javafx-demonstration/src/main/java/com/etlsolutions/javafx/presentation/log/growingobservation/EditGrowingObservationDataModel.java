package com.etlsolutions.javafx.presentation.log.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;

/**
 *
 * @author zc
 */
public class EditGrowingObservationDataModel extends AbstractGrowingObservationDataModel {

    public EditGrowingObservationDataModel(GrowingObservation growingObservation) {
        super(growingObservation);
    }

    @Override
    public void save() {
        GrowingObservation dataUnit = get();
        dataUnit.setCommonValues(getValueWrapper);
        dataUnit.setStartTime(getStartTimeValueWrapper().getValue());
        dataUnit.setEndTime(getEndTimeValueWrapper().getValue());
        support.firePropertyChange(LIST_CHANGE_PROPERTY, true, false);
    }
}
