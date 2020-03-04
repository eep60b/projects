package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.system.ProjectManager;

/**
 *
 * @author zc
 */
public class PlantVarietyValueWrapper extends DataUnitValueWrapper {

    private final ObservableListWrapperA<String> aliases;
    private final ValueWrapper<String> latinNameValueWrapper;
    private final ValueWrapper<PlantSubGroup> plantSubGroupValueWrapper;

    public PlantVarietyValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, ObservableListWrapperA<String> aliases, String latinName, PlantSubGroup plantSubGroup) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.aliases = new ObservableListWrapperA<>(aliases);
        latinNameValueWrapper = new ValueWrapper<>(latinName);
        plantSubGroupValueWrapper = new ValueWrapper<>(plantSubGroup);
    }

    public PlantVarietyValueWrapper(PlantVariety variety) {
        super(variety);
        aliases = new ObservableListWrapperA<>(variety.getAliases());
        this.latinNameValueWrapper = new ValueWrapper<>(variety.getLatinName());
        this.plantSubGroupValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<PlantSubGroup>getItem(variety.getPlantSubGroupId()));
    }

    public ObservableListWrapperA<String> getAliases() {
        return aliases;
    }

    public ValueWrapper<String> getLatinNameValueWrapper() {
        return latinNameValueWrapper;
    }

    public ValueWrapper<PlantSubGroup> getPlantSubGroupValueWrapper() {
        return plantSubGroupValueWrapper;
    }
}
