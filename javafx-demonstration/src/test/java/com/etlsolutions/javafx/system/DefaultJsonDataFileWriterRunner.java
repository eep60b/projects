package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.GrowingMediumGroup;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import javafx.collections.FXCollections;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author zc
 */
public class DefaultJsonDataFileWriterRunner {
    
    private final Object[] objects;

    public DefaultJsonDataFileWriterRunner() {

        
        //Growing mediums
        GrowingMedium loam = PlantsFactory.createGrowingMedium(501, "Loam", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{32, 32, 16, 20, 0, 20, 7.0}, true);
        GrowingMedium sandySoll = PlantsFactory.createGrowingMedium(502, "Sandy soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{55, 35, 5, 5, 0, 5, 6.5}, true);
        GrowingMedium siltSoil = PlantsFactory.createGrowingMedium(503, "Silt soi", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{25, 50, 5, 10, 0, 10, 6.8}, true);
        GrowingMedium peatSoil = PlantsFactory.createGrowingMedium(504, "Peat soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{10, 10, 60, 10, 0, 10, 7.0}, true);
        GrowingMedium lightClaySoil = PlantsFactory.createGrowingMedium(505, "Clay soil (light)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{15, 15, 45, 15, 0, 10, 7.0}, true);
        GrowingMedium heavyClaySoil = PlantsFactory.createGrowingMedium(506, "Clay soil (heavy)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{8, 8, 54, 10, 0, 20, 7.0}, true);
        GrowingMedium chalkySoil = PlantsFactory.createGrowingMedium(507, "Chalky soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium multipurposeCompost = PlantsFactory.createGrowingMedium(508, "Multipurpose compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 80, 0, 20, 5.2}, true);
        GrowingMedium ericaceousCompost = PlantsFactory.createGrowingMedium(509, "Ericaceous compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium stonySoil = PlantsFactory.createGrowingMedium(510, "Stony soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{30, 10, 0, 5, 50, 5, 7.0}, true);
        GrowingMedium plantLiquidCulture = PlantsFactory.createGrowingMedium(511, "Plant liquid culture", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 0, 0, 100, 15}, true);
        GrowingMedium johnInnes1 = PlantsFactory.createGrowingMedium(512, "John Innes No. 1", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes2 = PlantsFactory.createGrowingMedium(513, "John Innes No. 2", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes3 = PlantsFactory.createGrowingMedium(514, "John Innes No. 3", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesSeeds = PlantsFactory.createGrowingMedium(515, "John Innes Seeds", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{45, 20, 10, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesPotting = PlantsFactory.createGrowingMedium(516, "John Innes Potting", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMediumGroup growingMediumGroup = new GrowingMediumGroup(FXCollections.observableArrayList(loam, sandySoll, siltSoil, peatSoil, lightClaySoil, heavyClaySoil, chalkySoil, multipurposeCompost,
                ericaceousCompost, stonySoil, plantLiquidCulture, johnInnes1, johnInnes2, johnInnes3, johnInnesSeeds, johnInnesPotting));

        objects = new Object[]{growingMediumGroup};
    }

    @Before
    public void setUp() {
    }

    @Test
    public void write() throws Exception {
        new DefaultJsonDataFileWriter().write(objects);
    }

}
