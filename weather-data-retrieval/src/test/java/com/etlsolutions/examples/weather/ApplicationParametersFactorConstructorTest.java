package com.etlsolutions.examples.weather;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ApplicationParametersFactorConstructor
 *
 * @author zc
 */
public final class ApplicationParametersFactorConstructorTest {

    /**
     * Test of constructor.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testConstructor() throws Exception {

        Constructor<?>[] constructors = ApplicationParametersFactory.class.getDeclaredConstructors();

        assertEquals(1, constructors.length);

        Constructor<?> constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

}
