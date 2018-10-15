package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.GrowingMediumGroup;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.GrowingMedium;
import com.etlsolutions.javafx.data.GrowingMediumFactory;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of of class RepositoryManager via concrete data. No Mockito used.
 *
 * @author zc
 */
public final class RepositoryManagerConcreteTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private final RepositoryManager instance = RepositoryManager.getInstance();

    private final ObservableList<GrowingMedium> defaultGrowingMediums = FXCollections.observableArrayList();

    @Before
    public void setUp() {

        GrowingMedium loam = GrowingMediumFactory.getInstance().createGrowingMedium(501, "Loamy Soil", "", FXCollections.<ImageLink>observableArrayList(new ImageLink("aa", "cc"), new ImageLink("aa", "cc"), new ImageLink("ffsxa", "cfsfcc")), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        GrowingMedium sandySoll = GrowingMediumFactory.getInstance().createGrowingMedium(502, "Sandy Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{50, 35, 5, 5, 0, 5, 6.5}, true);
        GrowingMedium siltSoil = GrowingMediumFactory.getInstance().createGrowingMedium(503, "Silty soi", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{25, 50, 5, 10, 0, 10, 6.8}, true);
        GrowingMedium peatSoil = GrowingMediumFactory.getInstance().createGrowingMedium(504, "Peaty Soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{10, 10, 60, 10, 0, 10, 7.0}, true);
        GrowingMedium lightClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(505, "Clay Soil (light)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{15, 15, 45, 15, 0, 10, 7.0}, true);
        GrowingMedium heavyClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(506, "Clay Soil (heavy)", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{10, 10, 60, 10, 0, 10, 7.0}, true);
        GrowingMedium chalkySoil = GrowingMediumFactory.getInstance().createGrowingMedium(507, "Chalky soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium multipurposeCompost = GrowingMediumFactory.getInstance().createGrowingMedium(508, "Multipurpose Compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 80, 0, 20, 5.2}, true);
        GrowingMedium ericaceousCompost = GrowingMediumFactory.getInstance().createGrowingMedium(509, "Ericaceous Compost", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium stonySoil = GrowingMediumFactory.getInstance().createGrowingMedium(510, "Stony soil", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{30, 10, 0, 5, 50, 5, 7.0}, true);
        GrowingMedium plantLiquidCulture = GrowingMediumFactory.getInstance().createGrowingMedium(511, "Plant liquid culture", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{0, 0, 0, 0, 0, 100, 15}, true);
        GrowingMedium johnInnes1 = GrowingMediumFactory.getInstance().createGrowingMedium(512, "John Innes No. 1", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        GrowingMedium johnInnes2 = GrowingMediumFactory.getInstance().createGrowingMedium(513, "John Innes No. 2", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        GrowingMedium johnInnes3 = GrowingMediumFactory.getInstance().createGrowingMedium(514, "John Innes No. 3", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        GrowingMedium johnInnesSeeds = GrowingMediumFactory.getInstance().createGrowingMedium(515, "John Innes Seeds", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        GrowingMedium johnInnesPotting = GrowingMediumFactory.getInstance().createGrowingMedium(516, "John Innes Potting", "", FXCollections.<ImageLink>observableArrayList(), 0, "", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);
        defaultGrowingMediums.addAll(loam, sandySoll, siltSoil, peatSoil, lightClaySoil, heavyClaySoil, chalkySoil, multipurposeCompost,
                ericaceousCompost, stonySoil, plantLiquidCulture, johnInnes1, johnInnes2, johnInnes3, johnInnesSeeds, johnInnesPotting);
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(RepositoryManager.getInstance(), RepositoryManager.getInstance());
    }

    /**
     * Test of loadDefaultData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadDefaultGrowingMediums() throws Exception {

        String path = "target/test/resources/json/growing-medium-group.json";
        new File(path).getParentFile().mkdirs();
        new File(path).createNewFile();
        GrowingMediumGroup group = new GrowingMediumGroup(defaultGrowingMediums);
        mapper.writeValue(new File(path), group);
        assertEquals(group, instance.loadDefaultData(path, GrowingMediumGroup.class));
    }
}
