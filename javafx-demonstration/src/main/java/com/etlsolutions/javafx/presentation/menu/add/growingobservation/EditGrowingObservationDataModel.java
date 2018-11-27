package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

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
        
        dataUnit.setStartTime(getStartTimeValueWrapper().getValue());
        dataUnit.setEndTime(getEndTimeValueWrapper().getValue());
        super.save();
        
    }
}
