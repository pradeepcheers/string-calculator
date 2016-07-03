package com.arm.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Default implementation for {@code NumberFilter}
 */
public class NumberFilterImpl implements NumberFilter {

    @Override
    public List<Integer> filterBigNumbers(List<Integer> listOfNumbers, Integer limit) {
        return listOfNumbers.stream().filter(seq -> seq < limit).collect(Collectors.toList());
    }

    @Override
    public List<Integer> mapToInt(List<String> listOfString) {
        return null;
    }
}
