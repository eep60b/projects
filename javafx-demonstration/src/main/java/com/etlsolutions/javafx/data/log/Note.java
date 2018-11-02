package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class Note extends Log {

    public Note() {
    }

    public Note(LocalDateTime modifiedTime, LocalDateTime startTime, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(modifiedTime, startTime, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public Note(LocalDateTime modifiedTime, LocalDateTime startTime, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(modifiedTime, startTime, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }


}
