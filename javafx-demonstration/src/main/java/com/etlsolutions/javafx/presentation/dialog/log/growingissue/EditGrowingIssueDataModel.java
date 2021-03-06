package com.etlsolutions.javafx.presentation.dialog.log.growingissue;

import com.etlsolutions.javafx.data.log.GrowingIssue;

/**
 *
 * @author zc
 */
public class EditGrowingIssueDataModel extends AbstractGrowingIssueDataModel {

  
    public EditGrowingIssueDataModel(GrowingIssue growingIssue) {
        super(growingIssue);
    }

    @Override
    public void save() {
        GrowingIssue dataUnit = getItem();
        dataUnit.setCommonValues(getValueWrapper());
        dataUnit.setStartTime(getStartTimeValueWrapper().getValue());
        dataUnit.setEndTime(getEndTimeValueWrapper().getValue());
        dataUnit.setSolution(getSolutionValueWrapper().getValue());
        dataUnit.setEffectiveness(getEffectivenessValueWrapper().getValue());
        support.firePropertyChange(LIST_CHANGE_PROPERTY, true, false);
    }
}
