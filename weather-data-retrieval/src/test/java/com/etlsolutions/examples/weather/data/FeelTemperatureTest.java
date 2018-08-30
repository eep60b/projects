package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class FeelTemperature.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FeelTemperature.class, Logger.class})
public final class FeelTemperatureTest {

    private final Logger logger = Mockito.mock(Logger.class);    
    private final FeelTemperature instance = FeelTemperature.getInstance("73.82");
    
    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }  
    
    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertEquals(FeelTemperature.getInstance("73.82"), instance);
        assertNotSame(FeelTemperature.getInstance("73.82"), instance);
    }
    
    /**
     * Test of toString method, of class FeelTemperature.
     */
    @Test
    public void testGetValue() {
        assertEquals(73.82, instance.getValue(), 0.0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("FeelTemperature: 73.82", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("FTemp", instance.getShortName());
    }
}
