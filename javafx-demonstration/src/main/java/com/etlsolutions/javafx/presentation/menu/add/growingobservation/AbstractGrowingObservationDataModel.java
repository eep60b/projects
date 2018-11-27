package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.GrowingObservationValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class AbstractGrowingObservationDataModel extends DataUnitFXMLDataModel<GrowingObservation> {

    protected GrowingObservationValueWrapper growingObservationValueWrapper;

    public AbstractGrowingObservationDataModel() {
        growingObservationValueWrapper = new GrowingObservationValueWrapper();
    }

    public AbstractGrowingObservationDataModel(GrowingObservation growingObservation) {
        growingObservationValueWrapper = new GrowingObservationValueWrapper(growingObservation);
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return growingObservationValueWrapper.getStartTimeValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return growingObservationValueWrapper.getEndTimeValueWrapper();
    }
        
    @Override
    public String getFxmlPath() {
        return "/fxml/log/GrowingIssueObservation.fxml";
    }
}
