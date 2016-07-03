package com.arm.test;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code StringCalculator}
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculatorImpl();

    @Test
    public void shouldAddFromGivenString() {
        int sum = stringCalculator.add("2,3");

        assertThat(sum, is(5));
    }
}
