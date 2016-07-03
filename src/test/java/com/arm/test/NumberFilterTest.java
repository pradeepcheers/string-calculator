package com.arm.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@code NumberFilter}
 */
public class NumberFilterTest {

    private NumberFilter numberFilter = new NumberFilterImpl();

    @Test
    public void testFilterBigNumbers() {
        List<Integer> listOfIntegers = Lists.newArrayList(1, 120, 2);

        List<Integer> expectedListOfIntegers = Lists.newArrayList(1, 2);

        List<Integer> filteredListOfIntegers = numberFilter.filterBigNumbers(listOfIntegers, 100);

        assertThat(filteredListOfIntegers, is(expectedListOfIntegers));
    }
}
