package com.arm.test;

import com.google.common.collect.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code NumbersFilter}
 */
public class NumbersFilterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private NumbersFilter numbersFilter = new NumbersFilterImpl();

    @Test
    public void testFilterBigNumbers() {
        List<Integer> listOfIntegers = Lists.newArrayList(1, 120, 2);

        List<Integer> filteredListOfIntegers = numbersFilter.filterBigNumbers(listOfIntegers, 100);

        assertThat(filteredListOfIntegers, is(Lists.newArrayList(1, 2)));
    }

    @Test
    public void testMapToInt() {
        List<String> listOfString = Lists.newArrayList("1", "2");

        List<Integer> mappedIntegers = numbersFilter.mapToInt(listOfString);

        assertThat(mappedIntegers, is(Lists.newArrayList(1, 2)));
    }

    @Test
    public void testLogNegativeNumberAndThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed");

        List<Integer> listOfNumbers = Lists.newArrayList(-1, -5, 2);

        numbersFilter.logNegativeNumberAndThrowException(listOfNumbers);
    }
}
