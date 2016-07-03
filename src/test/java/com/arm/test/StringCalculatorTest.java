package com.arm.test;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code StringCalculator}
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculatorImpl();

    @Test
    public void shouldAddForAnEmptyString() {
        int result = stringCalculator.add("");

        assertThat(result, is(0));
    }

    @Test
    public void shouldAddForStringValueOne() {
        int result = stringCalculator.add("1");

        assertThat(result, is(1));
    }

    @Test
    public void shouldAddFromAGivenString() {
        int sum = stringCalculator.add("2,3");

        assertThat(sum, is(5));
    }

    @Test
    public void testAddToAllowUnknownAmountOfNumbers() {
        int result = stringCalculator.add("123456789,1,10,100");

        assertThat(result, CoreMatchers.is(123456900));
    }

    @Test
    public void testAddWithNewLineDelimiter() {
        int result = stringCalculator.add("1\n2,3");

        assertThat(result, is(6));
    }
}
