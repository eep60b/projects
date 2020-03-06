package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.javafx.data.log.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseTests extends GwiseLogGroup {
  
    @JsonIgnore
    public static final String TESTS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TESTS_PROPERTY";
    
    public List<Test> tests = new ArrayList<>();

    public GwiseTests(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseTests(GwiseLogGroupBean bean) {
        super(bean);
    }



    public List<Test> getTests() {
        return new ArrayList<>(tests);
    }

    public void setTests(List<Test> tests) {
        this.tests = new ArrayList<>(tests);
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
