package com.etlsolutions.javafx.data.log;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class GrowingIssue extends Log {

    @JsonIgnore
    public static final String SOLUTION_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingIssue.SOLUTION_PROPERTY";
    @JsonIgnore
    public static final String EFFECTIVENESS_PROPERTY = "com.etlsolutions.javafx.data.log.GrowingIssue.EFFECTIVENESS_PROPERTY";

    private String solution;
    private String effectiveness;

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        String oldValue = this.solution;
        this.solution = solution;
        fireChange(SOLUTION_PROPERTY, oldValue, this.solution);
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
