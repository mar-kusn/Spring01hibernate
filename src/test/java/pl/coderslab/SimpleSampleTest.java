package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SimpleSampleTest {

    @Test
    public void firstTest() {
        assertEquals(3, 5-2);
    }

    @Test
    public void secondTest() {
        assertEquals("ala", String.join("", Arrays.asList("a", "l", "a")));
    }

    @Before
    public void before() {
        System.out.println("Test will start now");
    }

    @After
    public void after() {
        System.out.println("Just after test");
    }
}
