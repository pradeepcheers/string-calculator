package com.arm.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code StringCalculator}
 */
@RunWith(value = Parameterized.class)
public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private StringCalculator stringCalculator = new StringCalculatorImpl();

    @Parameter(value = 0)
    public String numbers;

    @Parameter(value = 1)
    public int sum;

    @Test
    public void testAdd() {
        assertThat(stringCalculator.add(numbers), is(sum));
    }

    @Test
    public void throwExceptionOnAddingNegativeNumbers() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed ");

        stringCalculator.add("-5//-4;\n-1;2");
    }

    @Parameterized.Parameters(name = "{index}: test({0}) expected={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {"1", 1},
                {"2,3", 5},
                {"123456789,1,10,100", 111},
                {"1\n2,3", 6},
                {"//;\n1;2", 3},
                {";1001\n2", 2},
                {";1000\n2000\n4", 4},
                {"//[*][%]\\n1*2%3", 6},
                {"//[******][%%%%%]\\n1*2%3", 6}
        });
    }
}
