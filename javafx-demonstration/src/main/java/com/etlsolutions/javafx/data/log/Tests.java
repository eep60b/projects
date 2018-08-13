package com.etlsolutions.javafx.data.log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class Tests extends LogGroup {
  
    public static final String TESTS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TESTS_PROPERTY";
    public List<Test> tests = new ArrayList<>();

    public Tests() {
        super.setTitle("Tests");
    }

    public List<Test> getTests() {
        return new ArrayList<>(tests);
    }

    public void setTests(List<Test> tests) {
        this.tests = new ArrayList<>(tests);
        fireChange(TESTS_PROPERTY);
    }
}
