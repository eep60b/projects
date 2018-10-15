package com.etlsolutions.javafx.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class GrowingMediumFactory {

    private static final GrowingMediumFactory INSTANCE = new GrowingMediumFactory();

    public static final GrowingMediumFactory getInstance() {
        return INSTANCE;
    }

    public GrowingMedium createGrowingMedium(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {

        return new GrowingMedium(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, compositions, fertilised);
    }

    public GrowingMedium createGrowingMedium(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double[] compositions, boolean fertilised) {

        return new GrowingMedium(title, information, imageLinks, selectedImgLinkIndex, logoPath, compositions, fertilised);
    }

    public ObservableList<GrowingMedium> createDefaultGrowingMediums() {
        ObservableList<GrowingMedium> list = FXCollections.observableArrayList();
        GrowingMedium loam = GrowingMediumFactory.getInstance().createGrowingMedium(501, "Loamy Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{32, 32, 16, 20, 0, 20, 7.0}, true);
        GrowingMedium sandySoll = GrowingMediumFactory.getInstance().createGrowingMedium(502, "Sandy Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{55, 35, 5, 5, 0, 5, 6.5}, true);
        GrowingMedium siltSoil = GrowingMediumFactory.getInstance().createGrowingMedium(503, "Silty Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{25, 50, 5, 10, 0, 10, 6.8}, true);
        GrowingMedium peatSoil = GrowingMediumFactory.getInstance().createGrowingMedium(504, "Peaty Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{10, 10, 60, 10, 0, 10, 7.0}, true);
        GrowingMedium lightClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(505, "Clay Soil (light)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{15, 15, 45, 15, 0, 10, 7.0}, true);
        GrowingMedium heavyClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(506, "Clay Soil (heavy)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{8, 8, 54, 10, 0, 20, 7.0}, true);
        GrowingMedium chalkySoil = GrowingMediumFactory.getInstance().createGrowingMedium(507, "Chalky Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium multipurposeCompost = GrowingMediumFactory.getInstance().createGrowingMedium(508, "Multipurpose Compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 80, 0, 20, 5.2}, true);
        GrowingMedium ericaceousCompost = GrowingMediumFactory.getInstance().createGrowingMedium(509, "Ericaceous Compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium stonySoil = GrowingMediumFactory.getInstance().createGrowingMedium(510, "Stony Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{30, 10, 0, 5, 50, 5, 7.0}, true);
        GrowingMedium plantLiquidCulture = GrowingMediumFactory.getInstance().createGrowingMedium(511, "Plant Liquid Culture", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 0, 0, 100, 15}, true);
        GrowingMedium johnInnes1 = GrowingMediumFactory.getInstance().createGrowingMedium(512, "John Innes No. 1", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes2 = GrowingMediumFactory.getInstance().createGrowingMedium(513, "John Innes No. 2", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes3 = GrowingMediumFactory.getInstance().createGrowingMedium(514, "John Innes No. 3", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesSeeds = GrowingMediumFactory.getInstance().createGrowingMedium(515, "John Innes Seeds", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{45, 20, 10, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesPotting = GrowingMediumFactory.getInstance().createGrowingMedium(516, "John Innes Potting", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);        
        list.addAll(loam, sandySoll, siltSoil, peatSoil, lightClaySoil, heavyClaySoil, chalkySoil, multipurposeCompost, ericaceousCompost, stonySoil, plantLiquidCulture, johnInnes1, johnInnes2, johnInnes3, johnInnesSeeds, johnInnesPotting);
        return list;
    }
}