package com.arm.test;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code StringCalculator}
 */
public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
    public void shouldAddUnknownAmountOfNumbers() {
        int result = stringCalculator.add("123456789,1,10,100");

        assertThat(result, CoreMatchers.is(123456900));
    }

    @Test
    public void shouldAddWithNewLineDelimiter() {
        int result = stringCalculator.add("1\n2,3");

        assertThat(result, is(6));
    }

    @Test
    public void shouldAddForDelimiterWithLineSeparatorBeginningOfTheString() {
        int result = stringCalculator.add("//;\n1;2");

        assertThat(result, CoreMatchers.is(3));
    }

    @Test
    public void testAddForNegativeNumbers() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed ");

        stringCalculator.add("-5//-4;\n-1;2");
    }
}
