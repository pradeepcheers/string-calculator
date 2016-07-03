package com.arm.test.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default implementation for {@code NumbersFilter}
 */
@Component
public class NumbersFilterImpl implements NumbersFilter {

    public static final String NEGATIVES_NOT_ALLOWED = "Negatives not allowed ";

    @Override
    public List<Integer> filterBigNumbers(List<Integer> listOfNumbers, Integer limit) {
        return listOfNumbers.stream().filter(seq -> seq < limit).collect(Collectors.toList());
    }

    @Override
    public List<Integer> logNegativeNumberAndThrowException(List<Integer> listOfNumbers) {
        List<Integer> integers = new ArrayList<>();

        listOfNumbers = listOfNumbers.stream().filter(seq -> {
            if(seq < 0)
                integers.add(seq);

            return true;
        }).collect(Collectors.toList());

        if(integers.size() > 0)
            throw new IllegalArgumentException(NEGATIVES_NOT_ALLOWED + integers.toString());

        return listOfNumbers;
    }

    @Override
    public List<Integer> mapToInt(List<String> listOfString) {
        return listOfString
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
