package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogGroupBean extends GwiseDataUnitBean {

    private List<GwiseLogYearBean> years = new ArrayList<>();

    public GwiseLogGroupBean() {
    }

    public GwiseLogGroupBean(GwiseLogGroup group) {
        super(group);
        for(GwiseLogYear year : group.getYears()) {
            years.add(new GwiseLogYearBean(year));
        }
    }

    public List<GwiseLogYearBean> getYears() {
        return years;
    }

    public void setYears(List<GwiseLogYearBean> years) {
        this.years = years;
    }
}
