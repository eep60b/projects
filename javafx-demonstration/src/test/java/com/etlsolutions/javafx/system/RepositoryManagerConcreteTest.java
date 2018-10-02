package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public final class RepositoryManagerConcreteTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private final RepositoryManager instance = RepositoryManager.getInstance();

    private Object[][] defaultValues = {
        {501, "Loam", "", new String[]{}, new double[]{28, 28, 14, 20, 0, 10, 7.0}},
        {"Sandy soil", new double[]{50, 35, 5, 5, 0, 5, 6.5}},
        {"Silt soil", new double[]{25, 50, 5, 10, 0, 10, 6.8}},
        {"Peat soi", new double[]{10, 10, 5, 50, 0, 25, 6.3}},
        {"Clay soil (light)", new double[]{15, 15, 45, 15, 0, 10, 7.0}},
        {"Clay soil (heavy)", new double[]{10, 10, 60, 10, 0, 10, 7.0}},
        {"Chalky soil", new double[]{28, 28, 14, 10, 20, 10, 7.0}},
        {"Multipurpose compost", new double[]{0, 0, 0, 80, 0, 20, 7.0}},
        {"Ericaceous compost", new double[]{0, 0, 0, 80, 0, 20, 5.2}},
        {"Stony soil", new double[]{30, 10, 0, 5, 50, 5, 7.0}},
        {"Plant liquid culture", new double[]{0, 0, 0, 0, 0, 100, 15}}};

    private final ObservableList<GrowingMedium> defaultGrowingMediums = FXCollections.observableArrayList();

    @Before
    public void setUp() {
    }

    /**
     * Test of getInstance method, of class RepositoryManager.
     */
    @Test
    public void testGetInstance() {

        assertSame(RepositoryManager.getInstance(), RepositoryManager.getInstance());
    }

    /**
     * Test of loadDefaultGrowingMediums method, of class RepositoryManager.
     */
    @Test
    public void testLoadDefaultGrowingMediums() throws Exception {

        GrowingMedium g = PlantsFactory.createGrowingMedium("testy", "informationary", new double[]{28, 28, 14, 20, 0, 10, 7.0}, true);

        ObservableList<GrowingMedium> expResult = FXCollections.observableArrayList(g, g, g);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(new File("").getAbsolutePath());
        mapper.writeValue(new File("C:\\Temp\\j\\abbc.json"), expResult);
//        ObservableList<GrowingMedium> result = instance.loadDefaultGrowingMediums();
        //     assertEquals(expResult, result);

    }

}
