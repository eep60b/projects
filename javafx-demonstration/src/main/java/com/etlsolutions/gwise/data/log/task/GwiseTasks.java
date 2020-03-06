package com.etlsolutions.gwise.data.log.task;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.log.GwiseLogGroup;
import com.etlsolutions.gwise.data.log.GwiseLogGroupBean;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseTasks  extends GwiseLogGroup {
  
    public static final String TASKS_PROPERTY = "com.etlsolutions.javafx.data.log.Tests.TASKS_PROPERTY";
    public List<GwiseTasks> tasks = new ArrayList<>();

    public GwiseTasks(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, years);
    }

    public GwiseTasks(GwiseLogGroupBean bean) {
        super(bean);
    }

    public List<GwiseTasks> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<GwiseTasks> tests) {
        this.tasks = new ArrayList<>(tests);
  
    }

    @Override
    public GwiseDataUnitBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}