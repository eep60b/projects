package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class Note extends Log {

    public Note() {
    }

    public Note(DataUnitValueWrapper valueWrapper, LocalDateTime startTime) {
        super(valueWrapper, startTime);
    }

}
