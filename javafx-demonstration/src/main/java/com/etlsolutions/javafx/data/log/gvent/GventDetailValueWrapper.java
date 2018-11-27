package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public interface GventDetailValueWrapper {
    
    GventType getType();
    
    ValueWrapper<LocalDateTime> getStartTimeValueWrapper();
    
    ValueWrapper<LocalDateTime> getEndTimeValueWrapper();
    
    ObservableListWrapperA<Notification> getNotifications();
    
    
}
