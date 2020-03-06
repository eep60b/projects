package com.etlsolutions.gwise.data.log;

import com.etlsolutions.javafx.data.log.Test;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseTestsBean extends GwiseLogGroupBean {
    
    public List<Test> tests = new ArrayList<>();

    public GwiseTestsBean() {
    }

    public GwiseTestsBean(GwiseTests tests) {
        super(tests);
    }

    public List<Test> getTests() {
        return new ArrayList<>(tests);
    }

    public void setTests(List<Test> tests) {
        this.tests = new ArrayList<>(tests);
    }
}
