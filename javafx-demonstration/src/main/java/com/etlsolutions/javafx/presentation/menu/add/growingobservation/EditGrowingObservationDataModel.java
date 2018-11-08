package com.etlsolutions.javafx.presentation.menu.add.growingobservation;

import com.etlsolutions.javafx.data.log.GrowingObservation;

/**
 *
 * @author zc
 */
public class EditGrowingObservationDataModel extends AbstractGrowingObservationDataModel {

    public EditGrowingObservationDataModel(GrowingObservation growingObservation) {
        super(growingObservation);
    }

    
    
    @Override
    public void save() {
        item.setTitle(title);
        item.setInformation(information);
        item.setImageLinks(imageLinks);
        item.setSelectedImgLinkIndex(imageLinks.indexOf(selectedImageLink));
        item.setLogoPath(logoPath);
        item.setStartTime(startTime);
        item.setEndTime(endTime);
    }
}
