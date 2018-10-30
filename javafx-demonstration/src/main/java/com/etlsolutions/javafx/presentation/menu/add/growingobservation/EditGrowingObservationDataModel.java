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
        growingObservation.setTitle(title);
        growingObservation.setInformation(information);
        growingObservation.setImageLinks(imageLinks);
        growingObservation.setSelectedImgLinkIndex(imageLinks.indexOf(selectedImageLink));
        growingObservation.setLogoPath(logoPath);
        growingObservation.setStartTime(startTime);
        growingObservation.setEndTime(endTime);
    }
}
