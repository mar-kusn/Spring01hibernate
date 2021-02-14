package pl.coderslab.ut;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstTest {

    @Test
    public void shouldConcatString() {
        // given
        First first = new First();
        // when
        String actual = first.concatString("ala", "makota");
        // then
        assertEquals("alamakota", actual);
    }
    @Test
    public void shouldConcatStringWithNull() {
        // given
        First first = new First();
        // when
        String actual = first.concatString("napis", null);
        // then
        assertEquals("napisnull", actual);
    }

    @Test
    public void shouldConcatNullWithString() {
        // given
        First first = new First();
        // when
        String actual = first.concatString(null, "some String");
        // then
        assertEquals("nullsome String", actual);
    }

    @Test
    public void shouldConcatNullWithNull() {
        // given
        First first = new First();
        // when
        String actual = first.concatString(null, null);
        // then
        assertEquals("nullnull", actual);
    }

    @Test
    public void shouldMultiplyTwoPositiveNumbers() {
        // given
        First first = new First();
        // when
        int actual = first.multiply(2, 3);
        // then
        assertEquals(6, actual);
    }

    @Test
    public void shouldMultiplyTwoNegativeNumbers() {
        // given
        First first = new First();
        // when
        int actual = first.multiply(-12, -3);
        // then
        assertEquals(36, actual);
    }

    @Test
    public void shouldMultiplyByZero() {
        // given
        First first = new First();
        // when
        int actual = first.multiply(-12, 0);
        // then
        assertEquals(0, actual);
    }
}