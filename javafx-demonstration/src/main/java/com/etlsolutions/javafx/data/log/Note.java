package com.etlsolutions.javafx.data.log;

import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class Note extends Log {

    public Note() {
    }

    public Note(String title, String information, LocalDateTime startTime) {
        super(title, information, startTime);
    }
}
