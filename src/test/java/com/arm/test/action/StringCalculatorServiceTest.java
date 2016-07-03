package com.arm.test.action;

import com.arm.test.model.StringCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Tests for {@code StringCalculatorService}
 */
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorServiceTest {

    @InjectMocks
    private StringCalculatorService stringCalculatorService = new StringCalculatorServiceImpl();

    @Mock
    private StringCalculator stringCalculator;

    @Test
    public void testAdd() {
        when(stringCalculator.add("1,2")).thenReturn(3);

        Integer integer = stringCalculatorService.add("1,2");

        assertThat(integer, is(3));
    }
}
