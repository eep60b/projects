package com.etlsolutions.gwise.data.other;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ValueWrapper;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwiseGrowingMedium extends GwiseDataUnit {

    private final ValueWrapper<Double> sandPercentageValueWrapper;
    private final ValueWrapper<Double> siltPercentageValueWrapper;
    private final ValueWrapper<Double> clayPercentageValueWrapper;
    private final ValueWrapper<Double> organicPercentageValueWrapper;
    private final ValueWrapper<Double> stonePercentageValueWrapper;
    private final ValueWrapper<Double> waterStoragePercentageValueWrapper;
    private final ValueWrapper<Double> phValueWrapper;
    private final ValueWrapper<Boolean> fertilisedValueWrapper;

    public GwiseGrowingMedium(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath,
    double sandPercentage, double siltPercentage, double clayPercentage, double organicPercentage, double stonePercentage, double waterStoragePercentage, double ph, boolean fertilised) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        sandPercentageValueWrapper = new ValueWrapper<>(sandPercentage);
        siltPercentageValueWrapper = new ValueWrapper<>(siltPercentage);
        clayPercentageValueWrapper = new ValueWrapper<>(clayPercentage);
        organicPercentageValueWrapper = new ValueWrapper<>(organicPercentage);
        stonePercentageValueWrapper = new ValueWrapper<>(stonePercentage);
        waterStoragePercentageValueWrapper = new ValueWrapper<>(waterStoragePercentage);
        phValueWrapper = new ValueWrapper<>(ph);
        fertilisedValueWrapper = new ValueWrapper<>(fertilised);
    }

    public GwiseGrowingMedium(GwiseGrowingMediumBean bean) {
        this(bean.getId(), bean.getTitle(), bean.getInformation(), bean.getImageLinks(), bean.getSelectedImgLinkIndex(), bean.getLogoPath(),
                bean.getSandPercentage(), bean.getSiltPercentage(), bean.getClayPercentage(), bean.getOrganicPercentage(),
                bean.getStonePercentage(), bean.getWaterStoragePercentage(), bean.getPh(), bean.isFertilised());
    }

    @Override
    public GwiseGrowingMediumBean getBean() {
        return new GwiseGrowingMediumBean(this);
    }

    public ValueWrapper<Double> getSandPercentageValueWrapper() {
        return sandPercentageValueWrapper;
    }

    public ValueWrapper<Double> getSiltPercentageValueWrapper() {
        return siltPercentageValueWrapper;
    }

    public ValueWrapper<Double> getClayPercentageValueWrapper() {
        return clayPercentageValueWrapper;
    }

    public ValueWrapper<Double> getOrganicPercentageValueWrapper() {
        return organicPercentageValueWrapper;
    }

    public ValueWrapper<Double> getStonePercentageValueWrapper() {
        return stonePercentageValueWrapper;
    }

    public ValueWrapper<Double> getWaterStoragePercentageValueWrapper() {
        return waterStoragePercentageValueWrapper;
    }

    public ValueWrapper<Double> getPhValueWrapper() {
        return phValueWrapper;
    }

    public ValueWrapper<Boolean> getFertilisedValueWrapper() {
        return fertilisedValueWrapper;
    }
}
