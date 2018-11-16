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
        dataUnit.setTitle(title);
        dataUnit.setInformation(information);
        dataUnit.setImageLinks(imageLinks);
        dataUnit.setSelectedImgLinkIndex(imageLinks.indexOf(selectedImageLink));
        dataUnit.setLogoPath(logoPath);
        dataUnit.setStartTime(startTime);
        dataUnit.setEndTime(endTime);
    }
}
