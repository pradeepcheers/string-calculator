package com.arm.test;

import java.util.regex.Pattern;
import static org.springframework.util.Assert.hasText;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String numbers) {
        hasText(numbers, "Input cannot be null or empty");

        Pattern patten = Pattern.compile(",");

        return patten.splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
