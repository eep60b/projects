package com.etlsolutions.javafx.system;

import com.etlsolutions.gwise.system.SettingConstants;
import com.etlsolutions.gwise.system.RepositoryManager;
import com.etlsolutions.gwise.system.DefaultListFactory;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.subarea.location.LocationFactory;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.data.other.GrowingMediumGroup;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import static com.etlsolutions.gwise.system.SettingConstants.DEFAULT_DATA_DIRECTORY;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public class ProjectContentsReadWriteTest {

    private final ProjectContents instance = new ProjectContents();
    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws IOException {

        instance.setGrowingMediums(RepositoryManager.getInstance().loadDefaultData(DEFAULT_DATA_DIRECTORY + File.separator + GrowingMediumGroup.class.getSimpleName() + SettingConstants.JSON_FILE_EXTENSION, GrowingMediumGroup.class).getGrowingMediums());
        instance.setFertilisers(FertiliserFactory.getInstance().getDefaultFertilisers());
        instance.setLiquidFertilisers(FertiliserFactory.getInstance().getDefaultLiquidFertilisers());
        instance.setLocationDirections(LocationFactory.getInstance().getDefaultLocationDirections());
        instance.setLocationReferencePoints(LocationFactory.getInstance().getDefaultLocationReferencePoints());
        instance.setContainerShapes(LocationFactory.getInstance().getDefaultContainerShape());
        instance.setFlowerTypes(LogFactory.getInstance().getDefaultFlowerTypes());
        instance.setFlowerColors(LogFactory.getInstance().getDefaultFlowerColors());
        instance.setFruitShapes(LogFactory.getInstance().getDefaultFruitShapes());
        instance.setFruitColors(LogFactory.getInstance().getDefaultFruitColors());
        instance.setFertiliserUoms(FertiliserFactory.getInstance().getDefaultFertiliserUoms());
        instance.setWateringAmountUoms(LogFactory.getInstance().getDefaultWaterAmountUoms());
        instance.setWateringFluxUoms(LogFactory.getInstance().getDefaultWaterFluxUoms());
        instance.setSolidFertiliserDensityUoms(DefaultListFactory.getInstance().getDefaultSolidFertiliserDensityUoms());
        instance.setFertiliserDelutionRatioUoms(DefaultListFactory.getInstance().getDefaultFertiliserDilusionRatioUoms());
        instance.setAreaRoot(AreaFactory.getInstance().createAreaRoot());
        instance.setPlantsGroupRoot(PlantsFactory.getInstance().createPlantsGroupRoot());
        instance.setLogGroupRoot(LogFactory.getInstance().createLogGroupRoot());
    }

    /**
     * Test of the reading and writing JSON object of class ProjectContents.
     *
     * @throws java.io.IOException
     */
    @Test
    public void test() throws IOException {

        File file = new File("target/test/resources/json/project_content.json");
        file.getParentFile().mkdirs();
        file.createNewFile();

        mapper.writeValue(file, instance);

        ProjectContents result = mapper.readValue(file, ProjectContents.class);
        
        assertNotSame(instance, result);
        assertEquals(instance.getAreaRoot(), result.getAreaRoot());
        assertEquals(instance.getPlantsGroupRoot(), result.getPlantsGroupRoot());        
        assertEquals(instance.getLogGroupRoot(), result.getLogGroupRoot());        
        assertEquals(instance.getAreaRoot(), result.getAreaRoot());        
        
    }
}
