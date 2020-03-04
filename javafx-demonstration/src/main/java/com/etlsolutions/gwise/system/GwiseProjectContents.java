package com.etlsolutions.gwise.system;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.area.GwiseAreaRoot;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupRoot;
import com.etlsolutions.gwise.data.log.GwiseLogGroupRoot;
import com.etlsolutions.gwise.data.other.GwiseFertiliser;
import com.etlsolutions.gwise.data.other.GwiseFertiliserBean;
import com.etlsolutions.gwise.data.other.GwiseFertiliserFactory;
import com.etlsolutions.gwise.data.other.GwiseGrowingMedium;
import com.etlsolutions.gwise.data.other.GwiseGrowingMediumBean;
import com.etlsolutions.gwise.data.other.GwiseLiquidFertiliser;
import com.etlsolutions.gwise.data.other.GwiseLiquidFertiliserBean;
import com.etlsolutions.gwise.data.subarea.GwiseSubAreaType;
import com.etlsolutions.gwise.data.subarea.SubareaLogoItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The GwiseProjectContent class contains all the contents of current project.
 *
 * @author zc
 */
public class GwiseProjectContents {

    private final GwiseAreaRoot areaRoot;
    private final GwisePlantGroupRoot plantsGroupRoot;
    private final GwiseLogGroupRoot logGroupRoot;
    private final ObservableListWrapperA<GwiseGrowingMedium> growingMediums;
    private final ObservableListWrapperA<GwiseFertiliser> fertilisers;
    private final ObservableListWrapperA<GwiseLiquidFertiliser> liquidFertilisers;

    private final ObservableListWrapperA<String> fertiliserUoms;
    private final ObservableListWrapperA<String> flowerTypes;
    private final ObservableListWrapperA<String> flowerColors;
    private final ObservableListWrapperA<String> fruitColors;
    private final ObservableListWrapperA<String> fruitShapes;
    private final ObservableListWrapperA<String> harvestingQualities;
    private final ObservableListWrapperA<String> harvestingUoms;
    private final ObservableListWrapperA<String> wateringAmountUoms;
    private final ObservableListWrapperA<String> wateringFluxUoms;
    private final ObservableListWrapperA<String> solidFertiliserDensityUoms;
    private final ObservableListWrapperA<String> fertiliserDelutionRatioUoms;
    
    //TODO: make this unmodifiable: Collections.unmodifiableMap(new LinkedHashMap<>(realMap));
    private final Map<GwiseSubAreaType, List<SubareaLogoItem>> subareaLogoItems = new HashMap<>();

    public GwiseProjectContents(GwiseAreaRoot areaRoot, GwisePlantGroupRoot plantsGroupRoot, GwiseLogGroupRoot logGroupRoot) {
        this.areaRoot = areaRoot;
        this.plantsGroupRoot = plantsGroupRoot;
        this.logGroupRoot = logGroupRoot;
        growingMediums = new ObservableListWrapperA<>();
        fertilisers = new ObservableListWrapperA<>();
        liquidFertilisers = new ObservableListWrapperA<>();
        fertiliserUoms = new ObservableListWrapperA<>();
        flowerTypes = new ObservableListWrapperA<>();
        flowerColors = new ObservableListWrapperA<>();
        fruitColors = new ObservableListWrapperA<>();
        fruitShapes = new ObservableListWrapperA<>();
        harvestingQualities = new ObservableListWrapperA<>();
        harvestingUoms = new ObservableListWrapperA<>();
        wateringAmountUoms = new ObservableListWrapperA<>();
        wateringFluxUoms = new ObservableListWrapperA<>();
        solidFertiliserDensityUoms = new ObservableListWrapperA<>();
        fertiliserDelutionRatioUoms = new ObservableListWrapperA<>();
    }

    public GwiseProjectContents(GwiseProjectContentsBean bean) {

        areaRoot = new GwiseAreaRoot(bean.getAreaRoot());
        plantsGroupRoot = new GwisePlantGroupRoot(bean.getPlantGroupRoot());
        logGroupRoot = new GwiseLogGroupRoot(bean.getLogGroupRoot());

        growingMediums = new ObservableListWrapperA<>();
        for (GwiseGrowingMediumBean g : bean.getGrowingMediums()) {
            growingMediums.add(new GwiseGrowingMedium(g));
        }
        
        fertilisers = new ObservableListWrapperA<>();
        for(GwiseFertiliserBean f : bean.getFertilisers()) {
            fertilisers.add(GwiseFertiliserFactory.getInstance().getFertiliser(f));
        }
        
        liquidFertilisers = new ObservableListWrapperA<>();
        for(GwiseLiquidFertiliserBean l : bean.getLiquidFertilisers()) {
            liquidFertilisers.add(new GwiseLiquidFertiliser(l));
        }

        fertiliserUoms = new ObservableListWrapperA<>(bean.getFertiliserUoms());
        flowerColors = new ObservableListWrapperA<>(bean.getFlowerColors());
        flowerTypes = new ObservableListWrapperA<>(bean.getFlowerTypes());
        fruitColors = new ObservableListWrapperA<>(bean.getFruitColors());
        fruitShapes = new ObservableListWrapperA<>(bean.getFruitShapes());
        harvestingQualities = new ObservableListWrapperA<>(bean.getHarvestingQualities());
        harvestingUoms = new ObservableListWrapperA<>(bean.getHarvestingUoms());
        wateringAmountUoms = new ObservableListWrapperA<>(bean.getWateringAmountUoms());
        wateringFluxUoms = new ObservableListWrapperA<>(bean.getWateringFluxUoms());
        solidFertiliserDensityUoms = new ObservableListWrapperA<>(bean.getSolidFertiliserDensityUoms());
        fertiliserDelutionRatioUoms = new ObservableListWrapperA<>(bean.getFertiliserDelutionRatioUoms());

    }

    public GwiseAreaRoot getAreaRoot() {
        return areaRoot;
    }

    public GwisePlantGroupRoot getPlantsGroupRoot() {
        return plantsGroupRoot;
    }

    public GwiseLogGroupRoot getLogGroupRoot() {
        return logGroupRoot;
    }

    public ObservableListWrapperA<GwiseGrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    public ObservableListWrapperA<GwiseFertiliser> getFertilisers() {
        return fertilisers;
    }

    public ObservableListWrapperA<GwiseLiquidFertiliser> getLiquidFertilisers() {
        return liquidFertilisers;
    }

    public ObservableListWrapperA<String> getFlowerTypes() {
        return flowerTypes;
    }

    public ObservableListWrapperA<String> getFlowerColors() {
        return flowerColors;
    }

    public ObservableListWrapperA<String> getFruitShapes() {
        return fruitShapes;
    }

    public ObservableListWrapperA<String> getFruitColors() {
        return fruitColors;
    }

    public ObservableListWrapperA<String> getFertiliserUoms() {
        return fertiliserUoms;
    }

    public ObservableListWrapperA<String> getHarvestingQualities() {
        return harvestingQualities;
    }

    public ObservableListWrapperA<String> getHarvestingUoms() {
        return harvestingUoms;
    }

    public ObservableListWrapperA<String> getWateringAmountUoms() {
        return wateringAmountUoms;
    }

    public ObservableListWrapperA<String> getWateringFluxUoms() {
        return wateringFluxUoms;
    }

    public ObservableListWrapperA<String> getSolidFertiliserDensityUoms() {
        return solidFertiliserDensityUoms;
    }

    public ObservableListWrapperA<String> getFertiliserDelutionRatioUoms() {
        return fertiliserDelutionRatioUoms;
    }

    public Map<GwiseSubAreaType, List<SubareaLogoItem>> getSubareaLogoItems() {
        return subareaLogoItems;
    }
}
