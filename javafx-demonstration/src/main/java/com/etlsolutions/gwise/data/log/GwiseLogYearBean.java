package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.DataUnitIdRegistry;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogYearBean extends GwiseDataUnitBean {

    private int year;
    private List<GwiseLogMonthBean> months = new ArrayList<>();

    public GwiseLogYearBean() {
    }

    public GwiseLogYearBean(int year) {
        setId(DataUnitIdRegistry.getInstance().createNewId());
        this.year = year;
    }
    
    public GwiseLogYearBean(GwiseLogYear year) {
        super(year);
        this.year = year.getYear();
        for(GwiseLogMonth month : year.getMonths()) {
            months.add(new GwiseLogMonthBean(month));
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<GwiseLogMonthBean> getMonths() {
        return months;
    }

    public void setMonths(List<GwiseLogMonthBean> months) {
        this.months = months;
    }
}
