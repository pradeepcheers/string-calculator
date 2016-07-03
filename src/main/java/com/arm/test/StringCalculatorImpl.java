package com.arm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    private static Pattern pattern = Pattern.compile("[,\n;/]");

    private List<Integer> negativeNumbers = new ArrayList<>();

    @Override
    public int add(String numbers) {

        Integer sum = pattern
                .splitAsStream(numbers)
                .filter(seq -> !seq.equals(""))
                .mapToInt(Integer::parseInt)
                .filter(seq -> seq < 1000)
                .filter(seq -> {
                    if(seq < 0) {
                        negativeNumbers.add(seq);
                    }
                    return true;
                })
                .sum();

        if(negativeNumbers.size() > 0)
            throw new IllegalArgumentException("Negatives not allowed " + negativeNumbers.toString());

        return sum;
    }
}
