package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetail;

/**
 *
 * @author zc
 */
public class FloweringGventDetailDataModel extends GventDetailDataModel<FloweringGventDetail> {
        
    public FloweringGventDetailDataModel(FloweringGventDetail floweringGventDetail) {
        super(floweringGventDetail);
    }

    public int getNumberPerPlant() {
        return detail.getNumberPerPlant();
    }

    public void setNumberPerPlant(int numberPerPlant) {
        detail.setNumberPerPlant(numberPerPlant);
    }

    public String getColor() {
        return detail.getColor();
    }

    public void setColor(String color) {
        detail.setColor(color);
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/FloweringGventFXML.fxml";
    }
    
}
