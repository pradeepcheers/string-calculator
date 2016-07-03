package com.arm.test;

import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    private static Pattern pattern = Pattern.compile("[,\n]");

    @Override
    public int add(String numbers) {

        return pattern.splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
