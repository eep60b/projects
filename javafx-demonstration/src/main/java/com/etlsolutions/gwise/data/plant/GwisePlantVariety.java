package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.GwiseDataUnitBean;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantVariety extends GwiseDataUnit {


    private final int plantSubGroupId; 
    private final ObservableListWrapperA<String> aliases;
    private final ValueWrapper<String> latinNameValueWrapper;    

    public GwisePlantVariety(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, int plantSubGroupId, List<String> aliases, String latinName) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantSubGroupId = plantSubGroupId;
        this.aliases = new ObservableListWrapperA<>(aliases);
        this.latinNameValueWrapper = new ValueWrapper<>(latinName);
    }
       
    public GwisePlantVariety(GwisePlantVarietyBean bean) {
        this(bean.getId(), bean.getTitle(), bean.getInformation(), bean.getImageLinks(), bean.getSelectedImgLinkIndex(), bean.getLogoPath(),
                bean.getPlantSubGroupId(), bean.getAliases(), bean.getLatinName());
    }

    @Override
    public GwiseDataUnitBean getBean() {
        return new GwisePlantVarietyBean(this);
    }

    public int getPlantSubGroupId() {
        return plantSubGroupId;
    }

    public ObservableListWrapperA<String> getAliases() {
        return aliases;
    }

    public ValueWrapper<String> getLatinNameValueWrapper() {
        return latinNameValueWrapper;
    }
    
    public String getLatinName() {
        return latinNameValueWrapper.getValue();
    }

    public void setLatinName(String latinName) {
        this.latinNameValueWrapper.setValue(latinName);
    }    
}
