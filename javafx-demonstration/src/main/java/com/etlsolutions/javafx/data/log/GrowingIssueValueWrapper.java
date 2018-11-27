package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingIssueValueWrapper {

    protected final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    protected final ValueWrapper<LocalDateTime> endTimeValueWrapper;
    protected final ValueWrapper<String> solutionValueWrapper;
    protected final ValueWrapper<String> effectivenessValueWrapper;

    public GrowingIssueValueWrapper() {
        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        endTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        solutionValueWrapper = new ValueWrapper<>("");
        effectivenessValueWrapper = new ValueWrapper<>("");
    }

    public GrowingIssueValueWrapper(GrowingIssue issue) {
        startTimeValueWrapper = new ValueWrapper<>(issue.getStartTime());
        endTimeValueWrapper = new ValueWrapper<>(issue.getEndTime());
        solutionValueWrapper = new ValueWrapper<>(issue.getSolution());
        effectivenessValueWrapper = new ValueWrapper<>(issue.getEffectiveness());
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }

    public ValueWrapper<String> getSolutionValueWrapper() {
        return solutionValueWrapper;
    }

    public ValueWrapper<String> getEffectivenessValueWrapper() {
        return effectivenessValueWrapper;
    }
}
