package pl.coderslab.ut;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    // add method tests
    @Test
    public void shouldAddTwoPositiveNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(1, 2);
        // then
        assertEquals(3, actual);
    }

    @Test
    public void shouldAddTwoNegativeNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(-3, -2);
        // then
        assertEquals(-5, actual);
    }

    @Test
    public void shouldAddPositiveAndNegativeNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(11, -2);
        // then
        assertEquals(9, actual);
    }

    @Test
    public void shouldAddNegativeAndPositiveNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(-11, 22);
        // then
        assertEquals(11, actual);
    }

    @Test
    public void shouldAddNegativeNumbersAndZero() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(-11, 0);
        // then
        assertEquals(-11, actual);
    }

    @Test
    public void shouldAddZeroAndNegativeNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(0, -21);
        // then
        assertEquals(-21, actual);
    }

    @Test
    public void shouldAddPositiveNumbersAndZero() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(33, 0);
        // then
        assertEquals(33, actual);
    }

    @Test
    public void shouldAddZeroAndPositiveNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(0, 8);
        // then
        assertEquals(8, actual);
    }

    @Test
    public void shouldAddTwoZeroNumbers() {
        // given
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // when
        int actual = simpleCalculator.add(0, 0);
        // then
        assertEquals(0, actual);
    }


    // addPositive method tests
    @Test
    public void shouldAddPositiveNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(2, 4);
        assertEquals(6, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddPositiveAndNegativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(2, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddNegativeAndPositiveNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(-52, 24);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddTwoNegativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(-2, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddPositiveAndZeroNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddZeroAndPositiveNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(0, 24);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddNegativeAndZeroNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(-21, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddZeroAndNegativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(0, -14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAddZeroAndZeroNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int actual = simpleCalculator.addPositve(0, 0);
    }

}