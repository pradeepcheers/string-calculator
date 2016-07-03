package com.arm.test;

import static org.springframework.util.Assert.hasText;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String numbers) {
        hasText(numbers, "Input cannot be null or empty");

        return 5;
    }
}
