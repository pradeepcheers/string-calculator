package com.arm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    private static final String DELIMITER = "[,\n;/\\\\n (\\[*\\]) (\\[%\\])]";

    private static Pattern pattern = Pattern.compile(DELIMITER);

    private static final int BIG_NUMBER_LIMIT = 1000;

    private static final int ZERO = 0;

    private List<Integer> negativeNumbers = new ArrayList<>();

    private CharactersFilter charactersFilter;

    private NumberFilter numberFilter;

    @Override
    public int add(String numbers) {

        List<String> filteredString = charactersFilter.filterEmptyCharacters(numbers, pattern);

        Integer sum = filteredString
                .stream()
                .mapToInt(Integer::parseInt)
                .filter(seq -> seq < BIG_NUMBER_LIMIT)
                .filter(seq -> {
                    if(seq < ZERO) {
                        negativeNumbers.add(seq);
                    }
                    return true;
                })
                .sum();

        if(negativeNumbers.size() > ZERO)
            throw new IllegalArgumentException("Negatives not allowed " + negativeNumbers.toString());

        return sum;
    }

    public void setCharactersFilter(CharactersFilter charactersFilter) {
        this.charactersFilter = charactersFilter;
    }

    public void setNumberFilter(NumberFilter numberFilter) {
        this.numberFilter = numberFilter;
    }
}
