package com.arm.test.model;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
public class StringCalculatorImpl implements StringCalculator {

    private static final String DELIMITER = "[,\n;/\\\\n (\\[*\\]) (\\[%\\])]";

    private static Pattern pattern = Pattern.compile(DELIMITER);

    private static final int BIG_NUMBER_LIMIT = 1000;

    private CharactersFilter charactersFilter;

    private NumbersFilter numbersFilter;

    @Override
    public int add(String numbers) {

        List<String> filteredString = charactersFilter.filterEmptyCharacters(numbers, pattern);

        List<Integer> listOfNumbers = numbersFilter.mapToInt(filteredString);

        listOfNumbers = numbersFilter.filterBigNumbers(listOfNumbers, BIG_NUMBER_LIMIT);

        listOfNumbers = numbersFilter.logNegativeNumberAndThrowException(listOfNumbers);

        return listOfNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    public void setCharactersFilter(CharactersFilter charactersFilter) {
        this.charactersFilter = charactersFilter;
    }

    public void setNumbersFilter(NumbersFilter numbersFilter) {
        this.numbersFilter = numbersFilter;
    }
}
