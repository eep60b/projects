package com.etlsolutions.gwise.data.plant;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePlantSubgroup extends GwiseDataUnit {

    /**
     * The parent plant group id of this plant subgroup. This field can be used
     * to look up its parent when necessary.
     */
    private final int plantGroupId;

    /**
     * All the plantSets belong to this plant sub group.
     */
    private final ObservableListWrapperA<GwiseLocationPlantSet> plantSets;

    /**
     * All the plant varieties belong to this plant sub group.
     *
     * This property will not be shown in the tree.
     *
     */
    private final ObservableListWrapperA<GwisePlantVariety> plantVarieties;

    public GwisePlantSubgroup(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, int plantGroupId, List<GwiseLocationPlantSet> plants, List<GwisePlantVariety> plantVarieties) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.plantGroupId = plantGroupId;
        this.plantSets = new ObservableListWrapperA<>(plants);
        this.plantVarieties = new ObservableListWrapperA<>(plantVarieties);
    }

    public GwisePlantSubgroup(GwisePlantSubgroupBean bean) {
        this(bean.getId(), bean.getTitle(), bean.getInformation(), bean.getImageLinks(), bean.getSelectedImgLinkIndex(), bean.getLogoPath(),
                bean.getPlantGroupId(), bean.getPlantSets(), bean.getPlantVarieties());
    }

    @Override
    public GwisePlantSubgroupBean getBean() {
        return new GwisePlantSubgroupBean(this);
    }

    public int getPlantGroupId() {
        return plantGroupId;
    }

    public ObservableListWrapperA<GwiseLocationPlantSet> getPlantSets() {
        return plantSets;
    }

    public ObservableListWrapperA<GwisePlantVariety> getPlantVarieties() {
        return plantVarieties;
    }
}
