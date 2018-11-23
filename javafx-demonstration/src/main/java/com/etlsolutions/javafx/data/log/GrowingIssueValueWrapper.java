package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingIssueValueWrapper {

    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected final ValueWrapper<String> solutionValueWrapper;
    protected final ValueWrapper<String> effectivenessValueWrapper;

    public GrowingIssueValueWrapper() {
        startTime = LocalDateTime.now();
        endTime = LocalDateTime.now();
        solutionValueWrapper = new ValueWrapper<>("");
        effectivenessValueWrapper = new ValueWrapper<>("");
    }

    public GrowingIssueValueWrapper(GrowingIssue issue) {
        startTime = issue.getStartTime();
        endTime = issue.getEndTime();
        solutionValueWrapper = new ValueWrapper<>(issue.getSolution());
        effectivenessValueWrapper = new ValueWrapper<>(issue.getEffectiveness());
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ValueWrapper<String> getSolutionValueWrapper() {
        return solutionValueWrapper;
    }

    public ValueWrapper<String> getEffectivenessValueWrapper() {
        return effectivenessValueWrapper;
    }
}
