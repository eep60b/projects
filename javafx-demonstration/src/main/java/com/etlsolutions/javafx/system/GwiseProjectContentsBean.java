package com.etlsolutions.javafx.system;

import com.etlsolutions.gwise.data.area.GwiseAreaRootBean;
import com.etlsolutions.gwise.data.log.GwiseLogGroupRootBean;
import com.etlsolutions.gwise.data.other.GwiseFertiliser;
import com.etlsolutions.gwise.data.other.GwiseFertiliserBean;
import com.etlsolutions.gwise.data.other.GwiseGrowingMedium;
import com.etlsolutions.gwise.data.other.GwiseGrowingMediumBean;
import com.etlsolutions.gwise.data.other.GwiseLiquidFertiliser;
import com.etlsolutions.gwise.data.other.GwiseLiquidFertiliserBean;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupRootBean;
import java.util.ArrayList;
import java.util.List;

/**
 * The java bean class for the GwiseProjectContent class which contains all the
 * contents of current project.
 *
 * @author zc
 */
public class GwiseProjectContentsBean {

    private GwiseAreaRootBean areaRoot;
    private GwisePlantGroupRootBean plantsGroupRoot;
    private GwiseLogGroupRootBean logGroupRoot;
    private List<GwiseGrowingMediumBean> growingMediums;
    private List<GwiseFertiliserBean> fertilisers;
    private List<GwiseLiquidFertiliserBean> liquidFertilisers;

    private List<String> fertiliserDelutionRatioUoms;
    private List<String> fertiliserUoms;
    private List<String> flowerTypes;
    private List<String> flowerColors;
    private List<String> fruitShapes;
    private List<String> fruitColors;
    private List<String> harvestingQualities;
    private List<String> harvestingUoms;
    private List<String> solidFertiliserDensityUoms;
    private List<String> wateringAmountUoms;
    private List<String> wateringFluxUoms;

    public GwiseProjectContentsBean() {
    }

    public GwiseProjectContentsBean(GwiseProjectContents contents) {
        areaRoot = contents.getAreaRoot().getBean();
        plantsGroupRoot = contents.getPlantsGroupRoot().getBean();
        logGroupRoot = contents.getLogGroupRoot().getBean();

        growingMediums = new ArrayList<>();
        for (GwiseGrowingMedium m : contents.getGrowingMediums()) {
            growingMediums.add(m.getBean());
        }

        fertilisers = new ArrayList<>();
        for (GwiseFertiliser f : contents.getFertilisers()) {
            fertilisers.add(f.getBean());
        }

        liquidFertilisers = new ArrayList<>();
        for (GwiseLiquidFertiliser l : contents.getLiquidFertilisers()) {
            liquidFertilisers.add(new GwiseLiquidFertiliserBean(l));
        }

        fertiliserDelutionRatioUoms = new ArrayList<>(contents.getFertiliserDelutionRatioUoms());
        fertiliserUoms = new ArrayList<>(contents.getFertiliserUoms());
        flowerColors = new ArrayList<>(contents.getFlowerColors());
        flowerTypes = new ArrayList<>(contents.getFlowerTypes());
        fruitColors = new ArrayList<>(contents.getFruitColors());
        fruitShapes = new ArrayList<>(contents.getFruitShapes());
        harvestingQualities = new ArrayList<>(contents.getHarvestingQualities());
        harvestingUoms = new ArrayList<>(contents.getHarvestingUoms());
        solidFertiliserDensityUoms = new ArrayList<>(contents.getSolidFertiliserDensityUoms());
        wateringAmountUoms = new ArrayList<>(contents.getWateringAmountUoms());
        wateringFluxUoms = new ArrayList<>(contents.getWateringFluxUoms());
    }

    public GwiseAreaRootBean getAreaRoot() {
        return areaRoot;
    }

    public void setAreaRoot(GwiseAreaRootBean areaRoot) {
        this.areaRoot = areaRoot;
    }

    public GwisePlantGroupRootBean getPlantsGroupRoot() {
        return plantsGroupRoot;
    }

    public void setPlantsGroupRoot(GwisePlantGroupRootBean plantsGroupRoot) {
        this.plantsGroupRoot = plantsGroupRoot;
    }

    public GwiseLogGroupRootBean getLogGroupRoot() {
        return logGroupRoot;
    }

    public void setLogGroupRoot(GwiseLogGroupRootBean logGroupRoot) {
        this.logGroupRoot = logGroupRoot;
    }

    public List<GwiseGrowingMediumBean> getGrowingMediums() {
        return growingMediums;
    }

    public void setGrowingMediums(List<GwiseGrowingMediumBean> growingMediums) {
        this.growingMediums = growingMediums;
    }

    public List<GwiseFertiliserBean> getFertilisers() {
        return fertilisers;
    }

    public void setFertilisers(List<GwiseFertiliserBean> fertilisers) {
        this.fertilisers = fertilisers;
    }

    public List<GwiseLiquidFertiliserBean> getLiquidFertilisers() {
        return liquidFertilisers;
    }

    public void setLiquidFertilisers(List<GwiseLiquidFertiliserBean> liquidFertilisers) {
        this.liquidFertilisers = liquidFertilisers;
    }

    public List<String> getFlowerTypes() {
        return flowerTypes;
    }

    public void setFlowerTypes(List<String> flowerTypes) {
        this.flowerTypes = flowerTypes;
    }

    public List<String> getFlowerColors() {
        return flowerColors;
    }

    public void setFlowerColors(List<String> flowerColors) {
        this.flowerColors = flowerColors;
    }

    public List<String> getFruitShapes() {
        return fruitShapes;
    }

    public void setFruitShapes(List<String> fruitShapes) {
        this.fruitShapes = fruitShapes;
    }

    public List<String> getFruitColors() {
        return fruitColors;
    }

    public void setFruitColors(List<String> fruitColors) {
        this.fruitColors = fruitColors;
    }

    public List<String> getFertiliserUoms() {
        return fertiliserUoms;
    }

    public void setFertiliserUoms(List<String> fertiliserUoms) {
        this.fertiliserUoms = fertiliserUoms;
    }

    public List<String> getHarvestingQualities() {
        return harvestingQualities;
    }

    public void setHarvestingQualities(List<String> harvestingQualities) {
        this.harvestingQualities = harvestingQualities;
    }

    public List<String> getHarvestingUoms() {
        return harvestingUoms;
    }

    public void setHarvestingUoms(List<String> harvestingUoms) {
        this.harvestingUoms = harvestingUoms;
    }

    public List<String> getWateringAmountUoms() {
        return wateringAmountUoms;
    }

    public void setWateringAmountUoms(List<String> wateringAmountUoms) {
        this.wateringAmountUoms = wateringAmountUoms;
    }

    public List<String> getWateringFluxUoms() {
        return wateringFluxUoms;
    }

    public void setWateringFluxUoms(List<String> wateringFluxUoms) {
        this.wateringFluxUoms = wateringFluxUoms;
    }

    public List<String> getSolidFertiliserDensityUoms() {
        return solidFertiliserDensityUoms;
    }

    public void setSolidFertiliserDensityUoms(List<String> solidFertiliserDensityUoms) {
        this.solidFertiliserDensityUoms = solidFertiliserDensityUoms;
    }

    public List<String> getFertiliserDelutionRatioUoms() {
        return fertiliserDelutionRatioUoms;
    }

    public void setFertiliserDelutionRatioUoms(List<String> fertiliserDelutionRatioUoms) {
        this.fertiliserDelutionRatioUoms = fertiliserDelutionRatioUoms;
    }

}
