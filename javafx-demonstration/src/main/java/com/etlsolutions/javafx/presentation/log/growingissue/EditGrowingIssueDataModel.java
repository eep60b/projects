package com.etlsolutions.javafx.presentation.log.growingissue;

/**
 *
 * @author zc
 */
public class EditGrowingIssueDataModel extends AbstractGrowingIssueDataModel {
    
    @Override
    public void save() {
        
        dataUnit.setStartTime(getStartTimeValueWrapper().getValue());
        dataUnit.setEndTime(getEndTimeValueWrapper().getValue());
        dataUnit.setSolution(getSolutionValueWrapper().getValue());
        dataUnit.setEffectiveness(getEffectivenessValueWrapper().getValue());
    }    
}
