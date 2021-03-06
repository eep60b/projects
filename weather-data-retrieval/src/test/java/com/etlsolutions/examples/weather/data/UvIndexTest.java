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
 * Test of class UvIndex.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UvIndex.class, Logger.class})
public final class UvIndexTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final UvIndex instance = UvIndex.getInstance("94");

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

        assertEquals(UvIndex.getInstance("94"), instance);
        assertNotSame(UvIndex.getInstance("94"), instance);       
    }    
    
    
    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        assertTrue(instance.getValue() == 94);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("UV Index: 94", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("UvIdx", instance.getShortName());
    }

}
