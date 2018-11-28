package com.etlsolutions.javafx.presentation.log.growingissue;

import com.etlsolutions.javafx.data.log.GrowingIssue;

/**
 *
 * @author zc
 */
public class EditGrowingIssueDataModel extends AbstractGrowingIssueDataModel {
    
    @Override
    public void save() {
        GrowingIssue dataUnit = get();
        dataUnit.setCommonValues(commonValueWrapper);
        dataUnit.setStartTime(getStartTimeValueWrapper().getValue());
        dataUnit.setEndTime(getEndTimeValueWrapper().getValue());
        dataUnit.setSolution(getSolutionValueWrapper().getValue());
        dataUnit.setEffectiveness(getEffectivenessValueWrapper().getValue());
    }    
}
