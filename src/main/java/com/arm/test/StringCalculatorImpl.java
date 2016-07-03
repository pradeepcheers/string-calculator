package com.arm.test;

import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    private static Pattern patten = Pattern.compile(",");

    @Override
    public int add(String numbers) {

        return patten.splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
