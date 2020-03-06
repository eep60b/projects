package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.DataUnitIdRegistry;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GwiseLogMonthBean extends GwiseDataUnitBean {
    
    private int month;
    private List<GwiseLogBean> logs = new ArrayList<>();

    public GwiseLogMonthBean() {
    }
    
    public GwiseLogMonthBean(int month) {
        setId(DataUnitIdRegistry.getInstance().createNewId());
        this.month = month;        
    }

    protected GwiseLogMonthBean(GwiseLogMonth month) {
        super(month);
        for(GwiseLog log : month.getLogs()) {
            logs.add(GwiseLogBeanFactory.getInstance().createLogBean(log));
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<GwiseLogBean> getLogs() {
        return logs;
    }

    public void setLogs(List<GwiseLogBean> logs) {
        this.logs = logs;
    }
}
