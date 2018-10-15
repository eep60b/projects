package com.etlsolutions.javafx.data.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class Tests extends LogGroup {
  
    @JsonIgnore
    public static final String TESTS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TESTS_PROPERTY";
    
    public List<Test> tests = new ArrayList<>();

    public Tests() {
        
    }

    public Tests(String title, String information) {
        super(title, information);
    }

    public List<Test> getTests() {
        return new ArrayList<>(tests);
    }

    public void setTests(List<Test> tests) {
        this.tests = new ArrayList<>(tests);
        fireChange(TESTS_PROPERTY);
    }
}
