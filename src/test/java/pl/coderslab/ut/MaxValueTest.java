package pl.coderslab.ut;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValueTest {

    @Test(expected = RuntimeException.class)
    public void shouldntGetMaxValueFromEmptyList() {
        int [] list = new int [0];
        int actual = MaxValue.largest(list);
    }

    @Test
    public void shouldGetMaxValueFromNotEmptyList() {
        int [] list = {-12, 0, -4, 7};
        int actual = MaxValue.largest(list);
        assertEquals(7, actual);
    }

    @Test(expected = RuntimeException.class)
    public void shouldntGetMaxValueFromNullList() {
        int actual = MaxValue.largest(null);
    }


}