package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingIssue extends Log {
   
    @JsonIgnore
    public static final String ENDTIME_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingIssue.ENDTIME_PROPERTY";    
    @JsonIgnore
    public static final String SOLUTION_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingIssue.SOLUTION_PROPERTY";
    @JsonIgnore
    public static final String EFFECTIVENESS_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingIssue.EFFECTIVENESS_PROPERTY";

    private LocalDateTime endTime;    
    private String solution;
    private String effectiveness;

    public GrowingIssue() {
    }

    public GrowingIssue(DataUnitValueWrapper valueWrapper, LocalDateTime startTime, LocalDateTime endTime, String solution, String effectiveness) {
        super(valueWrapper, startTime);
        this.endTime = endTime;
        this.solution = solution;
        this.effectiveness = effectiveness;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        LocalDateTime oldValue = this.endTime;
        this.endTime = endTime;
        support.fireChange(ENDTIME_PROPERTY, oldValue, this.endTime);
    }    
    
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        String oldValue = this.solution;
        this.solution = solution;
        support.fireChange(SOLUTION_PROPERTY, oldValue, this.solution);
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        String oldValue = this.effectiveness;
        this.effectiveness = effectiveness;
        fireChange(EFFECTIVENESS_PROPERTY, oldValue, this.effectiveness);
    }
}
