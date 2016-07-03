package com.arm.test.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Default implementation of {@code StringCalculator}
 */
@Component
public class StringCalculatorImpl implements StringCalculator {

    private static final String DELIMITER = "[,\n;/\\\\n (\\[*\\]) (\\[%\\]){}]";

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

    @Autowired
    @Required
    public void setCharactersFilter(CharactersFilter charactersFilter) {
        this.charactersFilter = charactersFilter;
    }

    @Autowired
    @Required
    public void setNumbersFilter(NumbersFilter numbersFilter) {
        this.numbersFilter = numbersFilter;
    }
}
