package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class GrowingIssueValueWrapper extends DataUnitValueWrapper {

    protected final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    protected final ValueWrapper<LocalDateTime> endTimeValueWrapper;
    protected final ValueWrapper<String> solutionValueWrapper;
    protected final ValueWrapper<String> effectivenessValueWrapper;

    public GrowingIssueValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime, String solution, String effectiveness) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        startTimeValueWrapper = new ValueWrapper<>(startTime);
        endTimeValueWrapper = new ValueWrapper<>(endTime);
        solutionValueWrapper = new ValueWrapper<>(solution);
        effectivenessValueWrapper = new ValueWrapper<>(effectiveness);
    }

    public GrowingIssueValueWrapper(GrowingIssue issue) {
        super(issue);
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
