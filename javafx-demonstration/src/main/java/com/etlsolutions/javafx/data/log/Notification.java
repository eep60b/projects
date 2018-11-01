package com.etlsolutions.javafx.data.log;

import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public class Notification {
    
    //Use ths to get task or gvent which contains title and start time.
    private int logId; 
    
    private int lengthBefore;       //How many minutes or days before the task or event start time.
    private NotificationTimeUnit timeUnit;
    private int repeatTimes; // Start from 1 but -1 is infinitive.

    public Notification() {
    }

    public Notification(int lengthBefore, NotificationTimeUnit timeUnit, int repeatTimes) {
        this.lengthBefore = lengthBefore;
        this.timeUnit = timeUnit;
        this.repeatTimes = repeatTimes;
    }
    
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getLengthBefore() {
        return lengthBefore;
    }

    public void setLengthBefore(int lengthBefore) {
        this.lengthBefore = lengthBefore;
    }

    public NotificationTimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(NotificationTimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.logId;
        hash = 47 * hash + this.lengthBefore;
        hash = 47 * hash + Objects.hashCode(this.timeUnit);
        hash = 47 * hash + this.repeatTimes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notification other = (Notification) obj;
        if (this.logId != other.logId) {
            return false;
        }
        if (this.lengthBefore != other.lengthBefore) {
            return false;
        }
        if (this.repeatTimes != other.repeatTimes) {
            return false;
        }
        if (this.timeUnit != other.timeUnit) {
            return false;
        }
        return true;
    }
    
    
}
