package com.etlsolutions.javafx.data.log;

/**
 *
 * @author zc
 */
public enum NotificationTimeUnit {
    
    MINUTS("minutes"), HOURS("hours"), DAYS("days"), WEEKS("weeks");
    
    private final String displayString;
    
    private NotificationTimeUnit(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    } 
}
