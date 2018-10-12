package com.etlsolutions.javafx.data.log;

import java.util.Date;

/**
 *
 * @author Zhipeng
 */
public class Notification {
    
    private Date popUpTime;
    private long repeatPeriod;

    public Date getPopUpTime() {
        return popUpTime;
    }

    public void setPopUpTime(Date popUpTime) {
        this.popUpTime = popUpTime;
    }

    public long getRepeatPeriod() {
        return repeatPeriod;
    }

    public void setRepeatPeriod(long repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }  
}
