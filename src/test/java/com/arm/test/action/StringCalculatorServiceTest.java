package com.arm.test.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code StringCalculatorService}
 */
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorServiceTest {

    @InjectMocks
    private StringCalculatorService stringCalculatorService = new StringCalculatorServiceImpl();

    @Test
    public void testAdd() {
        Integer integer = stringCalculatorService.add("1,2");

        assertThat(integer, is(3));
    }
}
